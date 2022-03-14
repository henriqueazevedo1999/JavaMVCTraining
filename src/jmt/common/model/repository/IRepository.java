package jmt.common.model.repository;

import java.util.List;

public interface IRepository<T>
{
	 T get(long id);
	 List<T> getAll();
	 boolean save(T entity);
	 boolean update(T entity);
	 boolean delete(long id);
}
