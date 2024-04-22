package hibernate_onetoone_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoone_uni.dto.AadharCard;

public class AadharcardDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("abhi");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void deleteAadhar(int id) {
		
		AadharCard aadharCard = entityManager.find(AadharCard.class, id);
		
		entityTransaction.begin();
		entityManager.remove(aadharCard);
		entityTransaction.commit();
	}
	public void updateAadharCard(int id,AadharCard aadharCard) {
		
	}

	
}
