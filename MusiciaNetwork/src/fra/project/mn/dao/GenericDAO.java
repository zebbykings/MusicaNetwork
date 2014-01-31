package fra.project.mn.dao;

import java.io.Serializable;
import java.util.*;
import java.util.Map.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;


abstract class GenericDAO<T> implements Serializable {

	
	
 private static final long serialVersionUID = 1L;

 private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusciaNetworkPU");
 private EntityManager em;

 private Class<T> entityClass;
 
 public void beginTransaction() {
  em = emf.createEntityManager();

  em.getTransaction().begin();
 }

 public void commit() {
  em.getTransaction().commit();
 }

 public void rollback() {
  em.getTransaction().rollback();
 }

 public void closeTransaction() {
  em.close();
 }

 public void commitAndCloseTransaction() {
  commit();
  closeTransaction();
 }

 public void flush() {
  em.flush();
 }

 public void joinTransaction() {
  em = emf.createEntityManager();
  em.joinTransaction();
 }

 public GenericDAO(Class<T> entityClass) {
  this.entityClass = entityClass;
 }

 public void save(T entity) {
  em.persist(entity);
 }

 public void delete(T entity) {
  T entityToBeRemoved = em.merge(entity);
  em.remove(entityToBeRemoved);
 }
 public void deleteById(long id) {
	 T find = em.find(entityClass, id);
	 T entityToBeRemoved = em.merge(find);
	 em.remove(entityToBeRemoved);
 }

 public T update(T entity) {
  return em.merge(entity);
 }

 public T find(long entityID) {
  return em.find(entityClass, entityID);
 }
 
 public void clear() {
	 em.clear();
 }

 public T findReferenceOnly(int entityID) {
  return em.getReference(entityClass, entityID);
 }

 // Using the unchecked because JPA does not have a
 // em.getCriteriaBuilder().createQuery()<T> method
 @SuppressWarnings({ "unchecked", "rawtypes" })
 public List<T> findAll() {
  CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
  cq.select(cq.from(entityClass));
  
  List<T> resultList = em.createQuery(cq).getResultList();
  return resultList;
 }

 // Using the unchecked because JPA does not have a
 // query.getSingleResult()<T> method
 @SuppressWarnings("unchecked")
 protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
  T result = null;

  try {
   Query query = em.createNamedQuery(namedQuery);

   // Method that will populate parameters if they are passed not null and empty
   if (parameters != null && !parameters.isEmpty()) {
    populateQueryParameters(query, parameters);
   }

   result = (T) query.getSingleResult();

  } catch (NoResultException e) {
   System.out.println("No result found for named query: " + namedQuery);
  } catch (Exception e) {
   System.out.println("Error while running query: " + e.getMessage());
   e.printStackTrace();
  }

  return result;
 }

 @SuppressWarnings("unchecked")
 protected List<T> findMoreResult(String namedQuery, Map<String, Object> parameters) {
	 List<T> result = null;

  try {
   Query query = em.createNamedQuery(namedQuery);

   // Method that will populate parameters if they are passed not null and empty
   if (parameters != null && !parameters.isEmpty()) {
    populateQueryParameters(query, parameters);
   }

   result = (List<T>) query.getResultList();

  } catch (NoResultException e) {
   System.out.println("No result found for named query: " + namedQuery);
  } catch (Exception e) {
   System.out.println("Error while running query: " + e.getMessage());
   e.printStackTrace();
  }

  return result;
 }
 @SuppressWarnings("unchecked")
 protected void executeUpdateRemoveQuert(String namedQuery, Map<String, Object> parameters) {
	 
	 try {
		 Query query = em.createNamedQuery(namedQuery);
		 
		 // Method that will populate parameters if they are passed not null and empty
		 if (parameters != null && !parameters.isEmpty()) {
			 populateQueryParameters(query, parameters);
		 }
		 
		 query.executeUpdate();
		 
	 } catch (NoResultException e) {
		 System.out.println("No result found for named query: " + namedQuery);
	 } catch (Exception e) {
		 System.out.println("Error while running query: " + e.getMessage());
		 e.printStackTrace();
	 }
	 
 }
 
 private void populateQueryParameters(Query query, Map<String, Object> parameters) {
  for (Entry<String, Object> entry : parameters.entrySet()) {
   query.setParameter(entry.getKey(), entry.getValue());
  }
 }
 
 public void executeQuery(String sqlScript){
	 Query q = em.createNativeQuery(sqlScript);
	 q.executeUpdate();
 }
}