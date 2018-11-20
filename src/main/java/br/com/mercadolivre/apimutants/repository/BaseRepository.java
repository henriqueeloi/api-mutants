package br.com.mercadolivre.apimutants.repository;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	void save(T entity);
	T findOne(ID id);
	int count();
}
