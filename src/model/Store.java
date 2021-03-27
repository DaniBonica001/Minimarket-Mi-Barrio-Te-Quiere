package model;

import java.util.ArrayList;
import java.util.List;

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
	
	//Aqui debo manejar la excpeción de la creación de un client (2 condiciones: 1. no puede tener TI, 2. debe ser >18 años)
	public String registerNewPerson(int type, String idnumber) {
		String message="Cliente registrado existosamente";
		Person found = findPerson(idnumber);
		if (found==null) {
			if (type==1) {
				clients.add(new Person(Type.TI,idnumber));
			}else if (type==2) {
				clients.add(new Person(Type.CC,idnumber));
			}else if (type==3) {
				clients.add(new Person(Type.PP,idnumber));
			}else if (type==4) {
				clients.add(new Person(Type.CE,idnumber));				
			}else {
				message="Tipo de documento inexistente. No se registrará el client";
			}			
		}else {
			message="El cliente con id "+idnumber+" ya existe";
		}		
		return message;
	}
	
	

}
