package model;

import java.util.ArrayList;
import java.util.List;

import customExceptions.PersonWithTI;
import customExceptions.WrongDayofTheMonth;

public class Store {
	
	//Relations
	private List<Person> clients;
	
	public Store() {
		clients = new ArrayList<Person>();		
		
	}
	
	public Person findPerson(String id) {
		Person person =null;
		boolean exit=false;
		for (int i=0;i<clients.size() && !exit;i++) {
			if (clients.get(i).getIdNumber().equalsIgnoreCase(id)) {
				person= clients.get(i);
				exit=true;
			}
		}
		return person;
	}
	
	public String registerNewPerson(int type, String idnumber, int actualDay) throws PersonWithTI, WrongDayofTheMonth{
		String message="Cliente registrado existosamente";
		Person found = findPerson(idnumber);
		
		int penultimateNumber= Integer.parseInt(Character.toString(idnumber.charAt(idnumber.length()-2)));
		
		boolean penulNumber =isPar(penultimateNumber);
		boolean day = isPar(actualDay);
		
		if (found==null) {
			
			if (type==1) {
				message="";
				throw new PersonWithTI(type);				
			}else {
				if (type==2 && day==true && penulNumber==false || day==false && penulNumber==true) {					
					clients.add(new Person(Type.CC,idnumber));
				}else if (type==3 && day==true && penulNumber==false || day==false && penulNumber==true) {
					clients.add(new Person(Type.PP,idnumber));
				}else if (type==4 && day==true && penulNumber==false || day==false && penulNumber==true) {
					clients.add(new Person(Type.CE,idnumber));				
				}else {
					message="Tipo de documento inexistente. No se registrará el client";
					throw new WrongDayofTheMonth(actualDay,penultimateNumber);
					
				}				
			}
						
		}else {
			message="El cliente con id "+idnumber+" ya existe";
		}		
		return message;
	}
	
	public boolean isPar(int n) {
		boolean is=false;
		if (n%2==0) {
			is=true;
		}		
		return is;
		
	}
	
	

}
