package tabelas;

import java.util.Date;

public class Hospedagem {
	
	private Integer codHospedagem;  // PK
	private Integer codChale;       // FK
	private String estado;
	private Date dataInicio;
	private Date dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;
	
	private Cliente cliente;
	private Chale chale;
	
	
	public Hospedagem() {
	}

	public Hospedagem(Integer codHospedagem, Integer codChale, String estado, Date dataInicio, Date dataFim,Integer qtdPessoas, Double desconto, Double valorFinal, Cliente cliente, Chale chale) {
		
		this.codHospedagem = codHospedagem;
		this.codChale = codChale;
		this.estado = estado;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.qtdPessoas = qtdPessoas;
		this.desconto = desconto;
		this.valorFinal = valorFinal;
		this.cliente = cliente;
		this.chale = chale;
	}

	public Integer getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(Integer codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public Integer getCodChale() {
		return codChale;
	}

	public void setCodChale(Integer codChale) {
		this.codChale = codChale;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Chale getChale() {
		return chale;
	}

	public void setChale(Chale chale) {
		this.chale = chale;
	}
	
	
	
	
	
	
	
	
	

	
}
