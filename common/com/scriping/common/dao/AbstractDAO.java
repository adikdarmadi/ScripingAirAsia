package com.scriping.common.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.scriping.base.entity.StationList;
import com.scriping.common.util.HibernateUtil;


public abstract class AbstractDAO<T> implements DAO<T>{
	
	protected abstract Class<T> getDomainClass();

	
	public final Session getSession(){
		return SessionFactoryUtils.getSession(HibernateUtil.getSessionFactory(), true);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Session session = getSession();
		try{
			session.beginTransaction();
			return (List<T>) session.createQuery("from " + getDomainClass().getName() + " x  order by x.id asc").list();
		}catch (HibernateException e) {
			session.getTransaction().rollback();
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Long id) {
		Session session = getSession();
		try{
			Query query = session.createQuery("from " + getDomainClass().getSimpleName() + " domain where domain.id =:id ");
			query.setLong("id", id);
			return (T) query.uniqueResult();}
		catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@Override
	public Boolean insert(T obj) {
		Boolean a=false;
		Session session = getSession();
		try{
			session.save(obj);
			a=true;
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
		return a;
	}
	
	@Override
	public void persist(T obj) {
		Session session = getSession();
		try{
			session.persist(obj);
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@Override
	public Boolean update(T obj) {
		Session session = getSession();
		Boolean a=false;
		try{
			session.update(obj);
			a=true;
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
		return a;
	}
	
	@Override
	public void merge(T obj) {
		Session session = getSession();
		try{
			session.merge(obj);
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@Override
	public void delete(T obj) {
		Session session = getSession();
		try{
			session.delete(obj);
			session.getTransaction().commit();
		}catch (HibernateException e){
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	@Override
	public void deleteAll() {
		Session session = getSession();
		String stringQuery = "DELETE FROM StationList";
		Query query = session.createQuery(stringQuery);
		query.executeUpdate();


	}
	

	
	@Override
	public Object execUnique(String query){
		Session session = getSession();
		try{
			return session.createQuery(query).uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@Override
	public Object execUnique(String query, Object[] parameters){
		Session session = getSession();
		try{
			Query object = session.createQuery(query);
			setParameters(object, parameters);
			return object.uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	@Override
	public Object execList(String query){
		Session session = getSession();
		try{
			return session.createQuery(query).list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}	
	}
	
	@Override
	public Object execList(String query, Object[] parameters){
		Session session = getSession();
		try{
			Query object = session.createQuery(query);
			setParameters(object, parameters);
			return object.list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}

	@Override
	public Object execUnique(Query query, Session session){
		try{
			return query.uniqueResult();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	@Override
	public Object execList(Query query, Session session){
		try{
			return query.list();
		}catch (HibernateException e) {
			throw SessionFactoryUtils.convertHibernateAccessException(e);
		}
	}
	
	
	private void setParameters(Query query, Object parameters[]){
	    if (parameters == null || parameters.length==0){
	        return;
	    }
	    
	    for (int i = 0; i < parameters.length; i++) {
	    	if (parameters[i] == null) {
	           
	        }
	    	query.setParameter(i, parameters[i]);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> comboGridFindLimitOffset(String criteriaName, Integer startRow, Integer endRow, String sidx, String sord, String searchTerm) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select x from "+getDomainClass().getSimpleName()+" x where x.id IS NOT NULL   ");
		buffer.append("and lower(x."+criteriaName+") like :search ");
		if(sidx != ""){
			buffer.append("order by x."+sidx+" "+sord);
		}
		
		Query query = getSession().createQuery(buffer.toString());
		query.setString("search", "%"+searchTerm+"%");
		
		query.setFirstResult(startRow);
		query.setMaxResults(endRow);
		
		return (List<T>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> comboGridFind(String criteriaName, String sidx, String sord, String searchTerm) {
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("select x from "+getDomainClass().getSimpleName()+" x where x.id IS NOT NULL   ");
		buffer.append("and lower(x."+criteriaName+") like :search ");
		if(sidx != ""){
			buffer.append("order by x."+sidx+" "+sord);
		}
		
		Query query = getSession().createQuery(buffer.toString());
		query.setString("search", "%"+searchTerm+"%");
		
		return (List<T>)query.list();
	}
	
}
