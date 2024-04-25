package hibernate_onetoone_uni.controller;

import java.util.Scanner;

import hibernate_onetoone_uni.dao.AadharcardDAO;
import hibernate_onetoone_uni.dao.PersonDao;
import onetoone_uni.dto.AadharCard;
import onetoone_uni.dto.Person;

public class MainController {

	static Scanner scanner = new Scanner(System.in);
	static PersonDao dao = new PersonDao();
	static AadharcardDAO dao2 = new AadharcardDAO();

     // task 102
	public static void m2(){
		//logic
	}

	public static void main(String[] args) {
		System.out.println(
				"Choice a option \n1.Save Person \n2.Find Person By Id \n3.Find All Persons \n4.Delete Aadhar \n5.Update Aadhar \n6.Update person \n7.Update Both21");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			savePerson();
		}
			break;
		case 2: {
			System.out.println("Enter Person Id to find");
			dao.findPerson(scanner.nextInt());
		}
			break;
		case 3: {
			dao.fetchAllPerson();
		}
			break;
		case 4: {
			System.out.println("Enter ID to delete Aadharcard");
			dao.deleteAadhar(scanner.nextInt());
		}
			break;
		case 5: {
			System.out.println("Enter ID to Update Aadhar");
			updateAadhar();

		}
			break;
		case 6: {
			System.out.println("Enter ID to Update Person");
			updatePerson();

		}
		case 7: {

			updateBoth();

		}
			break;

		default:
			break;
		}

	}

	public static void updateBoth() {
		AadharCard aadharCard = new AadharCard();
		
		System.out.println("Enter ID for person whose details want update");
		int id =scanner.nextInt();

		System.out.println("Enter updated Name for aadhar");
		aadharCard.setName(scanner.next());

		System.out.println("Enter updated Address for aadhar");
		aadharCard.setAddress(scanner.next());

		Person person = new Person();
		System.out.println("Enter updated person details");
		System.out.println();

		person.setName(aadharCard.getName());

		System.out.println("Enter Updated Phone for person");
		person.setPhone(scanner.nextLong());

		person.setAddress(aadharCard.getAddress());

		System.out.println("Enter Updated Age for person");
		person.setAge(scanner.nextInt());

		person.setAadhar(aadharCard);
		
		dao.updateBoth(id,person,aadharCard);
	}

	public static void updateAadhar() {
		AadharCard aadharCard = new AadharCard();

		System.out.println("Enter old addhar Id to update");
		int oldid = scanner.nextInt();

		System.out.println("Enter new Id to Update");
		int newId = scanner.nextInt();

		dao.updateAadhar(oldid,newId);
	}

	public static void updatePerson() {

		Person person = new Person();

		int id = scanner.nextInt();

		System.out.println("Enter Name for person");
		person.setName(scanner.next());

		System.out.println("Enter Phone for person");
		person.setPhone(scanner.nextLong());

		System.out.println("Enter Address for aadhar");
		person.setAddress(scanner.next());

		System.out.println("Enter Age for person");
		person.setAge(scanner.nextInt());

		dao.updatePerson(id, person);

	}

	public static void savePerson() {

		AadharCard aadharCard = new AadharCard();

		System.out.println("Enter ID for aadhar");
		aadharCard.setId(scanner.nextInt());

		System.out.println("Enter Name for aadhar");
		aadharCard.setName(scanner.next());

		System.out.println("Enter Address for aadhar");
		aadharCard.setAddress(scanner.next());

		Person person = new Person();
		System.out.println("Enter person details");
		System.out.println();

		System.out.println("Enter ID for person");
		person.setId(scanner.nextInt());

		person.setName(aadharCard.getName());

		System.out.println("Enter Phone for person");
		person.setPhone(scanner.nextLong());

		person.setAddress(aadharCard.getAddress());

		System.out.println("Enter Age for person");
		person.setAge(scanner.nextInt());

		person.setAadhar(aadharCard);

		dao.savePerson(person);

	}
}
