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
	public void testPersonWitoutTI() throws PersonWithTI, WrongDayofTheMonth {
		setupScenary1();
		int type= 2;
		String idNumber="16710007";
		LocalDate actualDate = LocalDate.now();
		int actualDay=actualDate.getDayOfMonth();
		
		//Store store = new Store();
		store.registerNewPerson(type, idNumber, actualDay);
		
		assertNotEquals(1,type);	
	}
	
	@Test
	public void testPersonWithTI() throws PersonWithTI, WrongDayofTheMonth {
		setupScenary1();
		int type= 1;
		String idNumber="1107834340";
		LocalDate actualDate = LocalDate.now();
		int actualDay=actualDate.getDayOfMonth();
		
		//Store store = new Store();
		store.registerNewPerson(type, idNumber, actualDay);
		
		assertEquals(1,type);	
	}
	
	@Test
	public void testPersonWithDay() throws PersonWithTI, WrongDayofTheMonth {
		setupScenary1();
		int type= 2;
		String idNumber="31913012";
		LocalDate actualDate = LocalDate.now();
		int actualDay=actualDate.getDayOfMonth();
		
		//Store store = new Store();
		store.registerNewPerson(type, idNumber, actualDay);
		
		assertNotEquals(1, type);
	}

}
