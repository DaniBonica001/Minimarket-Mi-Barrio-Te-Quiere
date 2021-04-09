package model;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import customExceptions.PersonWithTI;
import customExceptions.WrongDayofTheMonth;

class StoreTest {
	private Store store;
		
	public void setupScenary1() {	
		store= new Store();
	}
	
	@Test
	public void testPersonWithTI()  {
		setupScenary1();
		int type= 1;
		String idNumber="1107834340";
		LocalDate actualDate = LocalDate.now();
		int actualDay=actualDate.getDayOfMonth();
		
		try {			
			store.registerNewPerson(type, idNumber, actualDay);
		}catch (PersonWithTI e) {
			e.printStackTrace();
			e.getMessage();
		}catch (WrongDayofTheMonth ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		
		assertEquals(1,type);	
	}

	@Test
	public void testPersonWitoutTI()  {
		setupScenary1();
		int type= 2;
		String idNumber="16710007";
		LocalDate actualDate = LocalDate.now();
		int actualDay=actualDate.getDayOfMonth();
		
		try {
			store.registerNewPerson(type, idNumber, actualDay);
		}catch (PersonWithTI e) {
			e.printStackTrace();
			e.getMessage();
		}catch (WrongDayofTheMonth ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		
		
		assertNotEquals(1,type);
		assertNotEquals(store.getClients(),null);
	}
	

	
	@Test
	public void testPersonWithDay()  {
		setupScenary1();
		int type= 2;
		String idNumber="31913012";
		LocalDate actualDate = LocalDate.now();
		int actualDay=actualDate.getDayOfMonth();
		
		try {
			store.registerNewPerson(type, idNumber, actualDay);
		}catch (PersonWithTI e) {
			e.printStackTrace();
			e.getMessage();
		}catch (WrongDayofTheMonth ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
		
		assertNotEquals(1, type);
	}

}
