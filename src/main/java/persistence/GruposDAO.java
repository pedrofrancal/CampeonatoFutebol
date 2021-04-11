package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Grupos;

public class GruposDAO {
	public void geraGrupos() throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "EXEC distribui_times";
		CallableStatement statement = con.prepareCall(sql);
		statement.execute();
	}

	public ArrayList<Grupos> buscaGrupos() throws SQLException {
		Connection con = ConnectionSingleton.getInstance().getConnection();
		String sql = "SELECT * FROM grupo_com_nome";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		ArrayList<Grupos> listaJogos = new ArrayList<>();

		while (rs.next()) {
			Grupos g = new Grupos();
			g.setCodigoTime(rs.getInt("CodigoTime"));
			g.setGrupo(rs.getString("Grupo"));
			g.setNomeTime(rs.getString("NomeTime"));
			listaJogos.add(g);
		}

		return listaJogos;
	}
}
