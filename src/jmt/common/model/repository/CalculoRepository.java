package jmt.common.model.repository;

import java.util.ArrayList;
import java.util.List;

import jmt.common.model.entity.Calculo;

public class CalculoRepository implements IRepository<Calculo>
{
	private static List<Calculo> calculos = new ArrayList<Calculo>();
	
	@Override
	public Calculo get(long id)
	{
		for (Calculo calculo : this.calculos)
		{
			if (calculo.getId() == id)
				return calculo;
		}

		return null;
	}

	@Override
	public List<Calculo> getAll()
	{
		return this.calculos;
	}

	@Override
	public boolean save(Calculo calculo)
	{
		if (get(calculo.getId()) != null)
			return false;
		
		calculos.add(calculo);
		return true;
	}

	@Override
	public boolean update(Calculo calculo)
	{
		Calculo antigo = get(calculo.getId());
		if (antigo == null)
			return false;
		
		antigo = calculo;
		return true;
	}

	@Override
	public boolean delete(long id)
	{
		Calculo calculo = get(id);
		if (calculo == null)
			return false;
		
		calculos.remove(calculo);
		return true;
	}
}
