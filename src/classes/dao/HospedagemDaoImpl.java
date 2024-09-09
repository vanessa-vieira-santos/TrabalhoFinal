package classes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import db.DB;
import db.DbExecption;
import tabelas.Chale;
import tabelas.Hospedagem;

public class HospedagemDaoImpl implements HospedagemDao {
	
	
    private Connection conn;
	
	public HospedagemDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public void inserir(Hospedagem obj) {
	    PreparedStatement st = null;
	    try {
	        String sql = "INSERT INTO Hospedagem (codChale, estado, dataInicio, dataFim, qtdPessoas, desconto, valorFinal) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

	        st.setInt(1, obj.getCodChale());
	        st.setString(2, obj.getEstado());
	        st.setDate(3, new java.sql.Date(obj.getDataInicio().getTime()));  
	        st.setDate(4, new java.sql.Date(obj.getDataFim().getTime()));    
	        st.setInt(5, obj.getQtdPessoas());
	        st.setDouble(6, obj.getDesconto());
	        st.setDouble(7, obj.getValorFinal());

	        int rowsAffected = st.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            ResultSet rs = st.getGeneratedKeys();
	            if (rs.next()) {
	                int id = rs.getInt(1);  
	                System.out.println("Inserido com sucesso. CodHospedagem gerado: " + id);
	            }
	        } else {
	            System.out.println("Erro ao inserir");
	        }
	    } catch (SQLException e) {
	        throw new DbExecption(e.getMessage());
	    } finally {
	        DB.closeStatement(st);
	    }
	}

///

	@Override
	public void alterar(Hospedagem obj) {
	    PreparedStatement st = null;
	    
	    try {
	        String sql = "UPDATE hospedagem SET CodChale = ?, estado = ?, dataInicio = ?, dataFim = ?, qtdPessoas = ?, desconto = ?, valorFinal = ? WHERE CodHospedagem = ?";
	        st = conn.prepareStatement(sql);
	        
	        st.setInt(1, obj.getCodChale());
	        st.setString(2, obj.getEstado());
	        st.setDate(3, new java.sql.Date(obj.getDataInicio().getTime()));  
	        st.setDate(4, new java.sql.Date(obj.getDataFim().getTime()));    
	        st.setInt(5, obj.getQtdPessoas());
	        st.setDouble(6, obj.getDesconto());
	        st.setDouble(7, obj.getValorFinal());
	        st.setInt(8, obj.getCodHospedagem()); 
	        
	        int rowsUpdated = st.executeUpdate(); 
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	       
	    } finally {
	        
	        if (st != null) {
	            try {
	                st.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}



	@Override
	public void excluir(Hospedagem obj) {
			PreparedStatement st = null;
			try {
				st = conn.prepareStatement("DELETE FROM hospedagem WHERE codHospedagem = ?");
				
				st.setInt(1,obj.getCodHospedagem());
				
				st.executeUpdate();
			}
			catch (SQLException e) {
				throw new DbExecption(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
		}


	public List<Hospedagem> listarTodos() {
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    List<Hospedagem> lista = new ArrayList<>();

	    try {
	        st = conn.prepareStatement("SELECT * FROM hospedagem ORDER BY codHospedagem");

	        rs = st.executeQuery();

	        while (rs.next()) {
	            Hospedagem hospedagem = new Hospedagem();
	            hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
	            hospedagem.setCodChale(rs.getInt("codChale"));
	            hospedagem.setEstado(rs.getString("estado"));
	            hospedagem.setDataInicio(rs.getDate("dataInicio"));
	            hospedagem.setDataFim(rs.getDate("dataFim"));
	            hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
	            hospedagem.setDesconto(rs.getDouble("desconto"));
	            hospedagem.setValorFinal(rs.getDouble("valorFinal"));

	            lista.add(hospedagem);
	        }
	    } catch (SQLException e) {
	        throw new DbExecption(e.getMessage());
	    } finally {
	        DB.closeStatement(st);
	        DB.closeResultSet(rs);
	    }

	    return lista;
	}

	@Override
	public Hospedagem pesquisarPorcodHospedagem(Integer codHospedagem) {
	    PreparedStatement st = null;
	    ResultSet rs = null;
	    Hospedagem hospedagem = null;

	    try {
	        st = conn.prepareStatement("SELECT * FROM hospedagem WHERE codHospedagem = ?");
	        st.setInt(1, codHospedagem);
	        
	        rs = st.executeQuery();

	        if (rs.next()) {
	            hospedagem = new Hospedagem();
	            hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
	            hospedagem.setCodChale(rs.getInt("codChale"));
	            hospedagem.setEstado(rs.getString("estado"));
	            hospedagem.setDataInicio(rs.getDate("dataInicio"));
	            hospedagem.setDataFim(rs.getDate("dataFim"));
	            hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
	            hospedagem.setDesconto(rs.getDouble("desconto"));
	            hospedagem.setValorFinal(rs.getDouble("valorFinal"));
	        }
	    } catch (SQLException e) {
	        throw new DbExecption(e.getMessage());
	    } finally {
	        DB.closeStatement(st);
	        DB.closeResultSet(rs);
	    }

	    return hospedagem;
	}

	@Override
	public Hospedagem pesquisarPorcodChale(Integer codChale) {
		 PreparedStatement st = null;
		    ResultSet rs = null;
		    Hospedagem hospedagem = null;

		    try {
		        st = conn.prepareStatement("SELECT * FROM hospedagem WHERE codChale = ?");
		        st.setInt(1, codChale);
		        
		        rs = st.executeQuery();

		        if (rs.next()) {
		            hospedagem = new Hospedagem();
		            hospedagem.setCodHospedagem(rs.getInt("codHospedagem"));
		            hospedagem.setCodChale(rs.getInt("codChale"));
		            hospedagem.setEstado(rs.getString("estado"));
		            hospedagem.setDataInicio(rs.getDate("dataInicio"));
		            hospedagem.setDataFim(rs.getDate("dataFim"));
		            hospedagem.setQtdPessoas(rs.getInt("qtdPessoas"));
		            hospedagem.setDesconto(rs.getDouble("desconto"));
		            hospedagem.setValorFinal(rs.getDouble("valorFinal"));
		        }
		    } catch (SQLException e) {
		        throw new DbExecption(e.getMessage());
		    } finally {
		        DB.closeStatement(st);
		        DB.closeResultSet(rs);
		    }

		    return hospedagem;
		}



}
