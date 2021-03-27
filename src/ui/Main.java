package ui;

import java.util.Scanner;

import model.Store;
import model.personWithTI;

public class Main {
	
	public static Store store;
	public final static  Scanner lector = new Scanner(System.in);
	
	//Atribute
	private static int counter;
	
	public static void main(String[] args) {
		createStore();
		
		boolean menu=true;
		while(menu) {
			System.out.println("\n1.Registro de una nueva persona"+
								"\n2.Consultar la cantidad de personas que han intendado ingresar al minimercado"+
								"\n3.Digite 3 para salir");
			int option = Integer.parseInt(lector.nextLine());
			
			switch(option) {
			case 1:
				registerNewPerson();
				
				break;
				
			case 2:
				System.out.println("Cantidad de personas que han intentado ingresar: "+counter);
				break;
				
			case 3: 
				System.out.println("Gracias por venir al minimercado");
				menu=false;				
				break;	
				
				default: System.out.println("Opción incorrecta");
				break;
			
			}
		}
	}
	
	public static void createStore() {
		store = new Store();
	}
	
	public static void registerNewPerson() {
		counter++;
		try {
			System.out.println("Ingrese el número correspondiente a su tipo de documento de identidad:"+
					"\n1.TI - Tarjeta de identidad"+
					"\n2.CC - Cédula de ciudadanía"+
					"\n3.PP - Pasaporte"+
					"\n4.CE - Cédula de Extranjería");
			int type = Integer.parseInt(lector.nextLine());
			if (type==1) {
				throw new personWithTI(type);
			}else {
				System.out.println("Ingrese el número del documento de identificación");
				String idnumber = lector.nextLine();

				String message="";
				message= store.registerNewPerson(type,idnumber);
				System.out.println(message);
			}	
			
		}catch(personWithTI ex) {
			System.out.println(ex.getMessage());
		}
	
		
	}

}
