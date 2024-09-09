package classes.dao;

import java.util.List;

import tabelas.Chale;


public interface ChaleDao {
	
	void inserir(Chale obj);
	void alterar(Chale obj);
	public void excluir(Integer CodChale);
	public List<Chale> listarTodos();
	public Chale pesquisarPorCodChale(Integer CodChale);
	
	
	

}
