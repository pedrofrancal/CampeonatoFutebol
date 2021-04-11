package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.JogosDAO;

@WebServlet("/geraJogos")
public class ServletJogos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletJogos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JogosDAO jd = new JogosDAO();
		try {
			jd.geraJogos();
		} catch (SQLException e) {
			System.out.println("GEROU JOGOS");
		}
		response.sendRedirect("index.jsp");
	}

}
