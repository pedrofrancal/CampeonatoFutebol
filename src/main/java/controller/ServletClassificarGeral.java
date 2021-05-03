package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Resultados;
import persistence.JogosDAO;

@WebServlet("/classificacaoGeral")
public class ServletClassificarGeral extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletClassificarGeral() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JogosDAO jd = new JogosDAO();

		@SuppressWarnings("unchecked")
		ArrayList<Resultados> agrupamentos[] = new ArrayList[4];
		for (int i = 0; i < agrupamentos.length; i++) {
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
		
		ArrayList<Resultados> ordenados = new ArrayList<Resultados>();
		
		for (ArrayList<Resultados> listagens : agrupamentos) {
				ordenados.addAll(listagens);
		}
		
		Collections.sort(ordenados, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				
				int comp;
				
				Integer x1 = ((Resultados) o1).getPontos();
				Integer x2 = ((Resultados) o2).getPontos();
				
				comp = x2.compareTo(x1);
				
				if(comp !=0) {
					return comp;
				}else {
					x1 = ((Resultados) o1).getVitorias();
					x2 = ((Resultados) o2).getVitorias();
					comp = x2.compareTo(x1);
					if(comp!=0) {
						x1 = ((Resultados) o1).getGolPro();
						x2 = ((Resultados) o2).getGolPro();
						comp = x2.compareTo(x1);
						
					}else {
						x1 = ((Resultados) o1).getSaldoGol();
						x2 = ((Resultados) o2).getSaldoGol();
						comp = x2.compareTo(x1);
					}
				}
				
				return comp;
			}
			
		});
		
		request.setAttribute("listagem", ordenados);
		request.getRequestDispatcher("/classificacao_geral.jsp").forward(request, response);
	}

}
