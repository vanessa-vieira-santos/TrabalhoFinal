package classes.dao;

import java.util.List;

import tabelas.Chale;
import tabelas.Hospedagem;

public interface HospedagemDao {
	
	public void inserir(Hospedagem obj);
	public void alterar(Hospedagem obj);
	public void excluir(Hospedagem obj);
	public  List<Hospedagem> listarTodos();
	public Hospedagem  pesquisarPorcodHospedagem(Integer codHospedagem );
	public Hospedagem  pesquisarPorcodChale(Integer codChale);
	
	

}
