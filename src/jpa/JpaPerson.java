package jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class JpaPerson {
	static EntityManager em;
	public JpaPerson(){
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("null");
	em = emf.createEntityManager();
	}
	public void insert(Person person){
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}
	public void delete(int personid){
		em.getTransaction().begin();
		Person person=em.find(Person.class, personid);
		em.remove(person);
		em.getTransaction().commit();
	}
	public void edit(Person person){
		em.getTransaction().begin();
		Person person2=em.find(Person.class, person.getPersonid());
		person2.setName(person.getName());
		person2.setCountry(person.getCountry());
		em.getTransaction().commit();
	}
	public List<Person> selectStar()
	{
		  	TypedQuery<Person> query =
		  	em.createQuery("SELECT p FROM Person p", Person.class);
		  	List<Person> results = query.getResultList();
		
			return results;
	}
	public Person editPerson(int personid){
		em.getTransaction().begin();
		Person person=em.find(Person.class, personid);
		em.getTransaction().commit();
		return person;
		
	}
}


