package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Jogos;
import model.Resultados;

public class JogosDAO {

	public void geraJogos() throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "EXEC gera_tabela_jogos";
		CallableStatement statement = con.prepareCall(sql);
		statement.execute();
	}

	public void atualizaJogos(Jogos j) throws SQLException {
		System.out.println(
				j.getCodigoTimeA() + "-" + j.getCodigoTimeB() + "-" + j.getGolsTimeA() + "-" + j.getGolsTimeB());
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "EXEC atualiza_jogos ?, ?, ?, ?";
		CallableStatement statement = con.prepareCall(sql);
		statement.setInt(1, Integer.parseInt(j.getCodigoTimeA()));
		statement.setInt(2, Integer.parseInt(j.getCodigoTimeB()));
		statement.setInt(3, j.getGolsTimeA());
		statement.setInt(4, j.getGolsTimeB());
		statement.execute();
	}

	public ArrayList<Jogos> buscaJogos() throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "SELECT * FROM jogos";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		ArrayList<Jogos> listaJogos = new ArrayList<>();

		while (rs.next()) {
			Jogos j = new Jogos();
			j.setCodigoTimeA(rs.getString("CodigoTimeA"));
			j.setCodigoTimeB(rs.getString("CodigoTimeB"));
			j.setGolsTimeA(rs.getInt("GolsTimeA"));
			j.setGolsTimeB(rs.getInt("GolsTimeB"));
			j.setDataJogo(rs.getDate("DataJogo").toLocalDate());
			listaJogos.add(j);
		}

		return listaJogos;
	}

	public ArrayList<Jogos> buscaData(String data) throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "SELECT * FROM jogos_em_data(?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, data);
		ResultSet rs = statement.executeQuery();

		ArrayList<Jogos> listaJogos = new ArrayList<>();

		while (rs.next()) {
			Jogos j = new Jogos();
			j.setCodigoTimeA(rs.getString("CodigoTimeA"));
			j.setCodigoTimeB(rs.getString("CodigoTimeB"));
			j.setGolsTimeA(rs.getInt("GolsTimeA"));
			j.setGolsTimeB(rs.getInt("GolsTimeA"));
			j.setDataJogo(rs.getDate("DataJogo").toLocalDate());
			j.setNomeTimeA(rs.getString("nomeTimeA"));
			j.setNomeTimeB(rs.getString("nomeTimeB"));
			listaJogos.add(j);
		}

		return listaJogos;
	}

	public ArrayList<Resultados> classificacao(String grupo) throws SQLException {

		ArrayList<Resultados> classificacao = new ArrayList<Resultados>();
		String sql = "SELECT cod, id, time_nome, num_jogos, vitoria, empate, derrota, gol_pro, gol_com, saldo_gol, pontos, grupo from gera_tabela_resultados(?) t left join grupos on grupos.CodigoTime = t.id";
		Connection con = ConnectionSingleton.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, grupo);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			Resultados r = new Resultados();

			r.setPosicao(rs.getInt("cod"));
			r.setId(rs.getInt("id"));
			r.setTime(rs.getString("time_nome"));
			r.setnJogos(rs.getInt("num_jogos"));
			r.setVitorias(rs.getInt("vitoria"));
			r.setEmpates(rs.getInt("empate"));
			r.setDerrotas(rs.getInt("derrota"));
			r.setGolPro(rs.getInt("gol_pro"));
			r.setGolCom(rs.getInt("gol_com"));
			r.setSaldoGol(rs.getInt("saldo_gol"));
			r.setPontos(rs.getInt("pontos"));
			r.setGrupo(rs.getString("grupo"));

			classificacao.add(r);

		}

		rs.close();
		ps.close();

		return classificacao;
	}
}
