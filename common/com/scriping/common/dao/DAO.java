package com.scriping.common.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public interface DAO<T> {

	List<T> findAll();

	T findById(Long id);

	Boolean insert(T obj);

	Boolean update(T obj);

	void delete(T obj);
	
	void deleteAll();

	Object execUnique(String query);

	Object execUnique(String query, Object[] parameters);

	Object execList(String query);

	Object execList(String query, Object[] parameters);

	Object execUnique(Query query, Session session);

	Object execList(Query query, Session session);

	List<T> comboGridFindLimitOffset(String criteriaName, Integer startRow,
			Integer endRow, String sidx, String sord, String searchTerm);

	List<T> comboGridFind(String criteriaName, String sidx, String sord,
			String searchTerm);

	void merge(T obj);

	void persist(T obj);

}
