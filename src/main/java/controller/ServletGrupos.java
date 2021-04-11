package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.GruposDAO;

@WebServlet("/geraGrupos")
public class ServletGrupos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletGrupos() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GruposDAO gd = new GruposDAO();
		try {
			gd.geraGrupos();
		} catch (SQLException e) {
			System.out.println("GEROU GRUPOS");
		}
		response.sendRedirect("index.jsp");
	}

}
