package classes.dao;

import java.util.List;

import tabelas.Cliente;



public interface ClienteDao {
	
	public String inserir(Cliente obj);
	public void alterar(Cliente obj);
	public void excluir(Cliente obj);
	public  List<Cliente> listarTodos();
	public Cliente pesquisarCodCliente(Integer CodCliente);
	

}
