package classes.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;


import db.DB;
import db.DbExecption;

import java.sql.PreparedStatement;

import tabelas.Chale;

public class ChaleDaoImpl implements ChaleDao {
	
	private Connection conn;
	
	public ChaleDaoImpl(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public void inserir(Chale obj) {
		
		PreparedStatement st = null;
		    try {
		        
		        String sql = "INSERT INTO Chale (localizacao, capacidade, valorAltaEstacao, valorBaixaEstacao) VALUES (?, ?, ?, ?)";
		        st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

		        
		        st.setString(1, obj.getLocalizacao());
		        st.setInt(2, obj.getCapacidade());
		        st.setDouble(3, obj.getValorAltaEstacao());
		        st.setDouble(4, obj.getValorBaixaEstacao());

		       
		        int rowsAffected = st.executeUpdate();
		        
		        if (rowsAffected > 0) {
		           
		            ResultSet rs = st.getGeneratedKeys();
		            if (rs.next()) {
		                int id = rs.getInt(1);
		                obj.setCodChale(id);  
		            }
		            System.out.println("Inserido com sucesso");
		        } else {
		            System.out.println("Erro ao inserir");
		        }
		    } catch (SQLException e) {
		        throw new DbExecption(e.getMessage());
		    } finally {
		        DB.closeStatement(st);
		    }
}

	@Override
	public void alterar(Chale obj) {
	    PreparedStatement st = null;
	    
	    try {
	    	
	        String sql = "UPDATE Chale SET localizacao = ?, capacidade = ?, valorAltaEstacao = ?, valorBaixaEstacao = ? WHERE CodChale = ?";
	        st = conn.prepareStatement(sql);
	        
	        st.setString(1, obj.getLocalizacao());
	        st.setInt(2, obj.getCapacidade());
	        st.setDouble(3, obj.getValorAltaEstacao());
	        st.setDouble(4, obj.getValorBaixaEstacao());
	        st.setInt(5, obj.getCodChale());  
	        
	        int rowsAffected = st.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Atualizado com sucesso!");
	        } else {
	            System.out.println("Erro: nenhum registro foi atualizado.");  // se o CodChale nao existirir, a msg de erro aparece.
	        }
	    } catch (SQLException e) {
	        throw new DbExecption(e.getMessage());
	    } finally {
	        DB.closeStatement(st);
	    }
	}


	@Override
	public void excluir(Integer CodChale) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM Chale WHERE CodChale = ?");

			st.setInt(1, CodChale);
			

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbExecption(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}

	}

	

	
	@Override
	public List<Chale> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM Chale ORDER BY CodChale");
			rs = st.executeQuery();

			List<Chale> list = new ArrayList<>();

			while (rs.next()) {
				Chale cha = new Chale();
				cha.setCodChale(rs.getInt("CodChale"));
				cha.setLocalizacao(rs.getString("localizacao"));
				cha.setCapacidade(rs.getInt("capacidade"));
				cha.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
				cha.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
				list.add(cha);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbExecption(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


	@Override
	public Chale pesquisarPorCodChale(Integer CodChale) {
		
		ResultSet rs = null;
		PreparedStatement st = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select * from chale where codChale = ?"); 
		
		try {
			st = conn.prepareStatement(sql.toString());
			st.setInt(1, CodChale);  
			rs = st.executeQuery();
			
			if((rs).next()) {
				Chale cha = new Chale();
				cha.setCodChale(rs.getInt("CodChale"));
				cha.setLocalizacao(rs.getString("localizacao"));
				cha.setCapacidade(rs.getInt("capacidade"));
				cha.setValorAltaEstacao(rs.getDouble("valorAltaEstacao"));
				cha.setValorBaixaEstacao(rs.getDouble("valorBaixaEstacao"));
				return cha;	
			}else {
				return null;
			}
		} catch(SQLException e) {
			throw new DbExecption(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
}
