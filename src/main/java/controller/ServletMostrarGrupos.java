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
import persistence.GruposDAO;

@WebServlet("/listagemGrupos")
public class ServletMostrarGrupos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletMostrarGrupos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GruposDAO gd = new GruposDAO();
		ArrayList<Grupos> listagem = new ArrayList<>();
		try {
			listagem = gd.buscaGrupos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		ArrayList<Grupos> agrupamentos[] = new ArrayList[4];
		
		for(int i = 0; i<agrupamentos.length; i++) {
			agrupamentos[i] = new ArrayList<Grupos>();
		}
		
		for(Grupos g : listagem) {
			String grupo = g.getGrupo();
			if(grupo.equalsIgnoreCase("a")) {
				agrupamentos[0].add(g);
			}else if(grupo.equalsIgnoreCase("b")) {
				agrupamentos[1].add(g);
			}else if(grupo.equalsIgnoreCase("c")) {
				agrupamentos[2].add(g);
			}else {
				agrupamentos[3].add(g);
			}
		}
		for(ArrayList<Grupos> listagens : agrupamentos) {
			System.out.println("listagem_"+listagens.get(0).getGrupo());
			request.setAttribute("listagem_"+listagens.get(0).getGrupo(), listagens);
		}
		request.getRequestDispatcher("/tabela.jsp").forward(request, response);
	}

}
