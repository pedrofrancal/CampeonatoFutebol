package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Jogos;

public class JogosDAO {

	public void geraJogos() throws SQLException {
			Connection con = ConnectionSingleton.getInstance().getConnection();
			String sql = "EXEC gera_tabela_jogos";
			CallableStatement statement = con.prepareCall(sql);
			statement.execute();
	}
	
	public ArrayList<Jogos> buscaJogos() throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "SELECT * FROM jogos";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		ArrayList<Jogos> listaJogos = new ArrayList<>();
		
		while(rs.next()) {
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
	
	public ArrayList<Jogos> buscaData(String data) throws SQLException{
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "SELECT * FROM jogos_em_data(?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, data);
		ResultSet rs = statement.executeQuery();
		
		ArrayList<Jogos> listaJogos = new ArrayList<>();
		
		while(rs.next()) {
			Jogos j = new Jogos();
			j.setCodigoTimeA(rs.getString("CodigoTimeA"));
			j.setCodigoTimeB(rs.getString("CodigoTimeB"));
			j.setDataJogo(rs.getDate("DataJogo").toLocalDate());
			j.setNomeTimeA(rs.getString("nomeTimeA"));
			j.setNomeTimeB(rs.getString("nomeTimeB"));
			listaJogos.add(j);
		}
		
		return listaJogos;
	}
}
