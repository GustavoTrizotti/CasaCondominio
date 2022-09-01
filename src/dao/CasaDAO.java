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
		String sql = "INSERT INTO Casa (numero, nomeProp, nomeCond) VALUES (?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getNumero());
			stmt.setString(2, c.getNomeProp());
			stmt.setString(3, c.getNomeCond());
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
				c.setNomeCond(rs.getString("nomeCond"));
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
	
	public int Remover(Casa c) {
		int removeu = 0;
		String sql = "DELETE FROM Casa WHERE numero = ?;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getNumero());
			removeu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return removeu;
	}
	
	public int Alterar(Casa c) {
		int alterou = 0;
		String sql = "UPDATE Casa SET nomeProp = ?, nomeCond=? WHERE numero = ?";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getNumero());
			stmt.setString(2, c.getNomeProp());
			stmt.setString(3, c.getNomeCond());
			alterou = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alterou;
	}
}
