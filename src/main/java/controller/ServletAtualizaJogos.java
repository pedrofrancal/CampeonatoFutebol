package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Jogos;
import persistence.JogosDAO;

@WebServlet("/atualizaJogos")
public class ServletAtualizaJogos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAtualizaJogos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println(request.getParameter("listagem"));
//		String listagem = 
		//ArrayList<Jogos> listagem = new ArrayList<Jogos>();
		Jogos jogos = new Jogos();
		JogosDAO jd = new JogosDAO();
		System.out.println("CHEGOU NO POST");
		for (int i = 1; i <= 8; i++) {
			jogos.setCodigoTimeA(request.getParameter("codigoA" + i));
			jogos.setCodigoTimeB(request.getParameter("codigoB" + i));
			jogos.setNomeTimeA(request.getParameter("timeA" + i));
			jogos.setNomeTimeB(request.getParameter("timeB" + i));
			jogos.setGolsTimeA(Integer.parseInt(request.getParameter("golsA" + i)));
			jogos.setGolsTimeB(Integer.parseInt(request.getParameter("golsB" + i)));
			System.out.println(jogos.getCodigoTimeA() + "-" + jogos.getCodigoTimeB() + "-" + jogos.getGolsTimeA() + "-"
					+ jogos.getGolsTimeB());
			try {
				jd.atualizaJogos(jogos);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("index.jsp");
	}

}
