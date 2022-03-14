package jmt.common.model.entity;

public class Calculo
{
	private long id;
	private TipoJuros tipoJuros;
	private double valorPrincipal;
	private double taxa;
	private int meses;
	private double montante;
	private double totalJuros;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public TipoJuros getTipoJuros()
	{
		return tipoJuros;
	}
	public void setTipoJuros(TipoJuros tipo)
	{
		this.tipoJuros = tipo;
	}
	public double getValorPrincipal()
	{
		return valorPrincipal;
	}
	public void setValorPrincipal(double valorPrincipal)
	{
		this.valorPrincipal = valorPrincipal;
	}
	public double getTaxa()
	{
		return taxa;
	}
	public void setTaxa(double taxa)
	{
		this.taxa = taxa;
	}
	public int getMeses()
	{
		return meses;
	}
	public void setMeses(int meses)
	{
		this.meses = meses;
	}
	public double getMontante()
	{
		return montante;
	}
	public void setMontante(double montante)
	{
		this.montante = montante;
	}
	public double getTotalJuros()
	{
		return totalJuros;
	}
	public void setTotalJuros(double totalJuros)
	{
		this.totalJuros = totalJuros;
	}
}
