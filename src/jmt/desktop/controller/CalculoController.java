package jmt.desktop.controller;

import java.text.NumberFormat;
import java.util.Locale;

import jmt.common.model.entity.Calculo;
import jmt.common.model.entity.TipoJuros;
import jmt.common.model.service.CalculoService;
import jmt.desktop.view.CalculoForm;

public class CalculoController implements IController
{
	private CalculoForm frame;

	@Override
	public void executa(Object view)
	{
		frame = (CalculoForm) view;
		Calculo calculo = new Calculo();
		calculo.setValorPrincipal(Double.parseDouble(frame.txtCapital.getText()));
		calculo.setTaxa(Double.parseDouble(frame.txtTaxa.getText()));
		calculo.setMeses(Integer.parseInt(frame.txtMeses.getText()));
		calculo.setTipoJuros(frame.rdbtnTipoJurosSimples.isSelected() ? TipoJuros.SIMPLES : TipoJuros.COMPOSTOS);
		
		calculo = calcular(calculo);
		
		String montante = doubleFormat(calculo.getMontante());
		String juros = doubleFormat(calculo.getTotalJuros());
		
		frame.txtTotalJuros.setText(juros);
		frame.txtMontante.setText(montante);
	}

	private String doubleFormat(double value)
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		nf.setMaximumFractionDigits(2);
		return nf.format(value);
	}

	private Calculo calcular(Calculo calculo)
	{
		CalculoService service = new CalculoService();
		return service.calcularJuros(calculo);
	}
}
