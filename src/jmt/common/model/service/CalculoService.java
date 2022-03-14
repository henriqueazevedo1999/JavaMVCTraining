package jmt.common.model.service;

import jmt.common.model.entity.Calculo;
import jmt.common.model.entity.TipoJuros;
import jmt.common.model.repository.CalculoRepository;

public class CalculoService
{
	private CalculoRepository calculoRepository;

	public CalculoService()
	{
		this.calculoRepository = new CalculoRepository();
	}
	
	public Calculo calcularJuros(Calculo calculo)
	{
		if (calculo.getTipoJuros() == TipoJuros.SIMPLES)
			return jurosSimples(calculo);
		
		if (calculo.getTipoJuros() == TipoJuros.COMPOSTOS)
			return jurosCompostos(calculo);
		
		return calculo;
	}
	
	private Calculo jurosSimples(Calculo calculo)
	{
		double principal = calculo.getValorPrincipal();
		double taxa = calculo.getTaxa() / 100;
		int meses = calculo.getMeses();
		double juros = principal * taxa * meses;
		double montante = principal * (1 + (taxa * meses));
		
		calculo.setTotalJuros(juros);
		calculo.setMontante(montante);
		salvar(calculo);
		return calculo;
	}
	
	private Calculo jurosCompostos(Calculo calculo)
	{
		double principal = calculo.getValorPrincipal();
		double taxa = calculo.getTaxa() / 100;
		int meses = calculo.getMeses();
		double montante = principal * Math.pow(1 + taxa, meses);
		double juros = montante - principal;
		
		calculo.setTotalJuros(juros);
		calculo.setMontante(montante);
		salvar(calculo);
		return calculo;
	}

	private void salvar(Calculo calculo)
	{
		this.calculoRepository.save(calculo);
	}
}
