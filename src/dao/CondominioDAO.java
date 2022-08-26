package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Condominio;

public class CondominioDAO {
	private Connection connection;
	
	public CondominioDAO() {
		connection = new FabricaConexoes().getConnection();
	}
	
	public int Inserir(Condominio cond) {
		int inseriu = 0;
		String sql = "INSERT INTO Casa (numero, nomeProp, numeroCond) VALUES (?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, cond.getNome());
			stmt.setInt(2, cond.getQtdCasas());
			stmt.setString(3, cond.getCidade());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Condominio> getLista() {
		String sql = "SELECT * FROM Condominio";
		PreparedStatement stmt;
		Condominio cond;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Condominio> casas = new ArrayList<>();
			while (rs.next()) {
				cond = new Condominio();
				cond.setNome(rs.getString("nome"));
				cond.setQtdCasas(rs.getInt("qtdCasas"));
				cond.setCidade(rs.getString("cidade"));
				casas.add(cond);
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
