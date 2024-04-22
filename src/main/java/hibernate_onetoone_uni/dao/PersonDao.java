package hibernate_onetoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class PersonDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("abhi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePerson(Person person) {

		entityTransaction.begin();
		entityManager.persist(person.getAadhar());
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public void findPerson(int id) {
		Person person = entityManager.find(Person.class, id);
		System.out.println(person);
	}

	public void fetchAllPerson() {

		Query query = entityManager.createQuery("select p from Person p");

		List<Person> list = query.getResultList();

		System.out.println(list);
	}

	public void deleteAadhar(int id) {

		Person person = entityManager.find(Person.class, id);

		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person.getAadhar());
			entityManager.remove(person);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}
	public void updatePerson(int id,Person person) {
		
		Person dbPerson = entityManager.find(Person.class, id);
		if (dbPerson!=null) {
			person.setId(id);
			person.setAadhar(dbPerson.getAadhar());
			entityTransaction.begin();
			entityManager.merge(person);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}

	public void updateBoth(int id, Person person, AadharCard aadharCard) {
	
		Person dbPerson = entityManager.find(Person.class, id);
		
		if (dbPerson!=null) {
			person.setId(id);
			aadharCard.setId(dbPerson.getAadhar().getId());
			person.getAadhar().setId(dbPerson.getAadhar().getId());
			entityTransaction.begin();
			entityManager.merge(person.getAadhar());
			entityManager.merge(person); 
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		
		}
		
	}

	public void updateAadhar(int oldId, int newId) {
		AadharCard dbAadhar  = entityManager.find(AadharCard.class, oldId);
		
		Query query = entityManager.createQuery("select p from Person p where aadharCard_a_id = ?1");
		query.setParameter(1,oldId);
		Person person=(Person) query.getSingleResult();
		
		if (dbAadhar!=null) {
			dbAadhar.setId(newId);
			person.setAadhar(dbAadhar);
			entityTransaction.begin();
			entityManager.merge(person);
			entityManager.merge(dbAadhar);
			entityTransaction.commit();
		} else {
			System.out.println("Id not found");
		}
	}

}
