package br.com.guilhermesolucoes.lojacrud.nucleo.utils.indicadores;

/**
 * @author Guilherme Pacheco De Medeiros
 * @version 1.0
 */

public enum IndSexo {
	
	MASCULINO(0, 'M', "masculino"),
	FEMININO(1, 'F', "feminino");
	
	private Integer indicador;
	private char primeiraLetra;
	private String descricao;
	
	IndSexo(Integer indicador, char primeiraLetra, String descricao) {
		this.indicador = indicador;
		this.primeiraLetra = primeiraLetra;
		this.descricao = descricao;
	}

	public Integer getIndicador() {
		return indicador;
	}

	public char getPrimeiraLetra() {
		return primeiraLetra;
	}

	public String getDescricao() {
		return descricao;
	}
		
}
