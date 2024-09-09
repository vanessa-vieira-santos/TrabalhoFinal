package tabelas;


public class Chale  {

	private Integer CodChale;
	private String localizacao;
	private Integer capacidade;
	private Double valorAltaEstacao;
	private Double valorBaixaEstacao;
	
	
	public Chale() {
	}
	
	
	public Chale(Integer codChale, String localizacao, Integer capacidade, Double valorAltaEstacao,
			Double valorBaixaEstacao) {
		
		CodChale = codChale;
		this.localizacao = localizacao;
		this.capacidade = capacidade;
		this.valorAltaEstacao = valorAltaEstacao;
		this.valorBaixaEstacao = valorBaixaEstacao;
	}
	
	

	@Override
	public String toString() {
		return "Chale [CodChale=" + CodChale + ", localizacao=" + localizacao + ", capacidade=" + capacidade
				+ ", valorAltaEstacao=" + valorAltaEstacao + ", valorBaixaEstacao=" + valorBaixaEstacao + "]";
	}


	public Integer getCodChale() {
		return CodChale;
	}
	public void setCodChale(Integer codChale) {
		CodChale = codChale;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Double getValorAltaEstacao() {
		return valorAltaEstacao;
	}
	public void setValorAltaEstacao(Double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}
	public Double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}
	public void setValorBaixaEstacao(Double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}

	
	

}
