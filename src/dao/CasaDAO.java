package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Casa;

public class CasaDAO {
	private Connection connection;
	
	public CasaDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int Inserir(Casa c) {
		int inseriu = 0;
		String sql = "INSERT INTO Casa (numero, nomeProp, numeroCond) VALUES (?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getNumero());
			stmt.setString(2, c.getNomeProp());
			stmt.setInt(3, c.getNumeroCond());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Casa> getLista() {
		String sql = "SELECT * FROM Casa";
		PreparedStatement stmt;
		Casa c;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Casa> casas = new ArrayList<>();
			while (rs.next()) {
				c = new Casa();
				c.setNumero(rs.getInt("numero"));
				c.setNomeProp(rs.getString("nomeProp"));
				c.setNumeroCond(rs.getInt("numeroCond"));
				casas.add(c);
			}
			rs.close();
			stmt.close();
			return casas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
