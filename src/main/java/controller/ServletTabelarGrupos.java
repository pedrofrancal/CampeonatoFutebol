package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupos;
import model.Resultados;
import persistence.GruposDAO;
import persistence.JogosDAO;

@WebServlet("/tabelarGrupos")
public class ServletTabelarGrupos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletTabelarGrupos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JogosDAO jd = new JogosDAO();
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Resultados> agrupamentos[] = new ArrayList[4];
		for(int i = 0; i<agrupamentos.length; i++) {
			agrupamentos[i] = new ArrayList<Resultados>();
		}
		
		try {
			agrupamentos[0] = jd.classificacao("A");
			agrupamentos[1] = jd.classificacao("B");
			agrupamentos[2] = jd.classificacao("C");
			agrupamentos[3] = jd.classificacao("D");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		for(ArrayList<Resultados> listagens : agrupamentos) {
			System.out.println("listagem_"+listagens.get(0).getGrupo());
			request.setAttribute("listagem_"+listagens.get(0).getGrupo(), listagens);
		}
		request.getRequestDispatcher("/tabela_grupos.jsp").forward(request, response);
	}

}
