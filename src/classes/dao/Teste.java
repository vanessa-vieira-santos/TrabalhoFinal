package classes.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
//import java.sql.Date;

import db.DB;
import db.DbExecption;
import tabelas.Chale;
import tabelas.Cliente;
import tabelas.Hospedagem;



public class Teste {

	public static void main(String[] args)  throws SQLException {
		
		ChaleDao chaleDao = DaoFactory.createChaleDao(); 
		ClienteDao cliDao = DaoFactory.createClienteDao();
		HospedagemDao hospDao =  DaoFactory.createHospedagemDao();
		
    	      /*Chale chal = chaleDao.pesquisarPorCodChale(1);
		      System.out.println(chal);
		      System.out.println("Pesquisa retornada!"); */
		
		       /*chaleDao.excluir(3);
		       System.out.println("Dado excluido!"); */
		
		       /*Connection conn = null;
			   conn = DB.getConnection();

			   List<Chale> chalList = chaleDao.listarTodos();

			   for (Chale chale : chalList) {
				    System.out.println("Código: " + chale.getCodChale());
				    System.out.println("Localização: " + chale.getLocalizacao());
				    System.out.println("Capacidade: " + chale.getCapacidade());
				    System.out.println("Valor Alta Estação: " + chale.getValorAltaEstacao());
				    System.out.println("Valor Baixa Estação: " + chale.getValorBaixaEstacao());
				    System.out.println("-------------------------");
				} */
		
		    
		      /* System.out.println("Testando o Inserir:");
		      Chale newch = new Chale(null, "testeee", 456, 20.6, 28.9); 
		      chaleDao.inserir(newch);
		      System.out.println("Inserido novo CodChale = " + newch.getCodChale());    */
		    
		     /* System.out.println("Testando o alterar:");
		      Chale chaleExistente = new Chale(6, "PaoDeAcucar", 500, 21.6, 27.9); 
		      chaleDao.alterar(chaleExistente);
		      System.out.println("Chale alterado: CodChale = " + chaleExistente.getCodChale() + ", Localizacao: " + chaleExistente.getLocalizacao());*/
		
		    		
	
			      
			      /*  Cliente cliente = new Cliente();  
			        cliente.setCodCliente(1); 

			        Chale chale = new Chale();  
			        chale.setCodChale(6);  

			      
			        LocalDate localDateInicio = LocalDate.of(2024, 9, 10);
			        LocalDate localDateFim = LocalDate.of(2024, 9, 15);
			        Date dataInicio = Date.valueOf(localDateInicio);
			        Date dataFim = Date.valueOf(localDateFim);

			        Hospedagem newHosp = new Hospedagem(
			            null,                     
			            4,                         
			            "Confirmada",              
			            dataInicio,                
			            dataFim,                   
			            4,                         
			            10.6,                      
			            206.3,                     
			            cliente,                   
			            chale                      
			        );

			        System.out.println("\n inserir =====");
					hospDao.inserir(newHosp);
					System.out.println("Inserted! New id = " + newHosp.getCodHospedagem()); */
		
        
		/*    Hospedagem hospedagem = new Hospedagem();
		    hospedagem.setCodHospedagem(5); 
		    hospedagem.setCodChale(4);
		    hospedagem.setEstado("Reservado");
		    hospedagem.setDataInicio(new java.util.Date()); 
		    hospedagem.setDataFim(new java.util.Date()); 
		    hospedagem.setQtdPessoas(4);
		    hospedagem.setDesconto(10.5);
		    hospedagem.setValorFinal(450.75);
		    
		    // Testando o método alterar
		    hospDao.alterar(hospedagem);
		    System.out.println("Alterado: " + hospedagem.getCodHospedagem());*/
		
		/*
	    Cliente cli = new Cliente();
	    cli.setCodCliente(2); 
	    cli.setNomeCliente("João Silva"); // Nome do cliente foi adicionado
	    cli.setRgCliente("123456789");
	    cli.setEnderecoCliente("Rua A, 123");
	    cli.setBairroCliente("Centro");
	    cli.setCidadeCliente("São Paulo");
	    cli.setEstadoCliente("SP");
	    cli.setCEPCliente("12345-678");
	    cli.setNascimentoCliente(new java.util.Date()); // Data atual para o nascimento
	    
	    // Testando o método alterar
	    cliDao.alterar(cli);
	    System.out.println("Alterado: " + cli.getCodCliente());*/
		
	
        
        
       /* Hospedagem obj = new Hospedagem();
        obj.setCodHospedagem(7);  

        try {
            hospDao.excluir(obj);
            System.out.println("Hospedagem excluida com sucesso!");
        } catch (DbExecption e) {
            System.out.println("Erro ao excluir hospedagem: " + e.getMessage());
        }*/
		
		 
        /*List<Hospedagem> listaHospedagem = hospDao.listarTodos();
        
        for (Hospedagem hospedagem : listaHospedagem) {
            System.out.println("Código da Hospedagem: " + hospedagem.getCodHospedagem());
            System.out.println("Código do Chalé: " + hospedagem.getCodChale());
            System.out.println("Estado: " + hospedagem.getEstado());
            System.out.println("Data de Início: " + hospedagem.getDataInicio());
            System.out.println("Data de Fim: " + hospedagem.getDataFim());
            System.out.println("Quantidade de Pessoas: " + hospedagem.getQtdPessoas());
            System.out.println("Desconto: " + hospedagem.getDesconto());
            System.out.println("Valor Final: " + hospedagem.getValorFinal());
            System.out.println("-------------------------");
        }*/
		
	
      
     /*   Integer codHospedagem = 8;  

        Hospedagem hospedagem = hospDao.pesquisarPorcodHospedagem(codHospedagem);
        
       
        if (hospedagem != null) {
            System.out.println("Codigo da Hospedagem: " + hospedagem.getCodHospedagem());
            System.out.println("Codigo do Chale: " + hospedagem.getCodChale());
            System.out.println("Estado: " + hospedagem.getEstado());
            System.out.println("Data de Inicio: " + hospedagem.getDataInicio());
            System.out.println("Data de Fim: " + hospedagem.getDataFim());
            System.out.println("Quantidade de Pessoas: " + hospedagem.getQtdPessoas());
            System.out.println("Desconto: " + hospedagem.getDesconto());
            System.out.println("Valor Final: " + hospedagem.getValorFinal());
        } else {
            System.out.println("Nenhuma hospedagem encontrada com o codigo fornecido.");
        }*/
		
        
       
        /*Cliente cliente = new Cliente();
        cliente.setCodCliente(1);  

        try {
            cliDao.excluir(cliente);
            System.out.println("Cliente excluído com sucesso!");
        } catch (DbExecption e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }*/
		 
        
        List<Cliente> listaClientes = cliDao.listarTodos();
        
        
        for (Cliente cliente : listaClientes) {
            System.out.println("Código do Cliente: " + cliente.getCodCliente());
            System.out.println("Nome do Cliente: " + cliente.getNomeCliente());
            System.out.println("RG do Cliente: " + cliente.getRgCliente());
            System.out.println("Endereço: " + cliente.getEnderecoCliente());
            System.out.println("Bairro: " + cliente.getBairroCliente());
            System.out.println("Cidade: " + cliente.getCidadeCliente());
            System.out.println("Estado: " + cliente.getEstadoCliente());
            System.out.println("CEP: " + cliente.getCEPCliente());
            System.out.println("Nascimento: " + cliente.getNascimentoCliente());
            System.out.println("-------------------------");
        }
    }

    
	   
			

}
		       


		
	
