package jmt.common.model.entity;

public enum TipoJuros
{
	SIMPLES(1, "Juros simples"),
	COMPOSTOS (2, "Juros compostos");
	
	private int valor;
	private String descricao;
	
	private TipoJuros(int valor, String descricao)
	{
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor()
	{
		return valor;
	}

	public String getDescricao()
	{
		return descricao;
	}
}
