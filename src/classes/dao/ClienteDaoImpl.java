package classes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import db.DB;
import db.DbExecption;
import tabelas.Cliente;
import tabelas.Hospedagem;

public class ClienteDaoImpl implements ClienteDao {
	
    private Connection conn;
	
	public ClienteDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void alterar(Cliente obj) {
	    PreparedStatement st = null;
	    
	    try {
	        String sql = "UPDATE Cliente SET nomeCliente = ?, rgCliente = ?, enderecoCliente = ?, bairroCliente = ?, cidadeCliente = ?, estadoCliente = ?, CEPCliente = ?, nascimentoCliente = ? WHERE CodCliente = ?";
	        st = conn.prepareStatement(sql);
	        
	        st.setString(1, obj.getNomeCliente());
	        st.setString(2, obj.getRgCliente());
	        st.setString(3, obj.getEnderecoCliente());
	        st.setString(4, obj.getBairroCliente());
	        st.setString(5, obj.getCidadeCliente());
	        st.setString(6, obj.getEstadoCliente());
	        st.setString(7, obj.getCEPCliente());
	        st.setDate(8, new java.sql.Date(obj.getNascimentoCliente().getTime()));
	        st.setInt(9, obj.getCodCliente()); // CodCliente no WHERE
	        
	        int rowsAffected = st.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Atualizado com sucesso!");
	        } else {
	            System.out.println("Erro: nenhum registro foi atualizado.");
	        }
	    } catch (SQLException e) {
	        throw new DbExecption(e.getMessage()); 
	    } finally {
	        DB.closeStatement(st); 
	    }
	}

	@Override
	public void excluir(Cliente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM Cliente WHERE codCliente = ?");
			
			st.setInt(1,obj.getCodCliente());
			
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
	public List<Cliente> listarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
				"SELECT * FROM Cliente ORDER BY CodCliente");
			rs = st.executeQuery();

			List<Cliente> list = new ArrayList<>();

			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setCodCliente(rs.getInt("CodCliente"));
				cli.setNomeCliente(rs.getString("nomeCliente"));
				cli.setRgCliente(rs.getString("rgCliente"));
				cli.setEnderecoCliente(rs.getString("enderecoCliente"));
				cli.setBairroCliente(rs.getString("bairroCliente"));
				cli.setCidadeCliente(rs.getString("cidadeCliente"));
				cli.setCEPCliente(rs.getString("CEPCliente"));
				cli.setNascimentoCliente(rs.getDate("nascimentoCliente"));
				list.add(cli);
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
	public Cliente pesquisarCodCliente(Integer CodCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inserir(Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}

