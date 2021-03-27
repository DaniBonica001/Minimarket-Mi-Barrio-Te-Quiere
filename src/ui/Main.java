package ui;

import java.util.Scanner;

import model.Store;

public class Main {
	
	public static Store store;
	public final static  Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("\n");
		createStore();
		
		boolean menu=true;
		while(menu) {
			System.out.println("\n1.Registro de una nueva persona"+
								"\n2.Consultar la cantidad de personas que han intendado ingresar al minimercado"+
								"\n3.Salir");
			int option = Integer.parseInt(lector.nextLine());
			
			switch(option) {
			case 1: registerNewPerson();
				break;
				
			case 2:
				break;
				
			case 3: 
				System.out.println("Gracias por venir al minimercado");
				menu=false;				
				break;	
				
				default: System.out.println("Opci�n incorrecta");
				break;
			
			}
		}
	}
	
	public static void createStore() {
		store = new Store();
	}
	
	public static void registerNewPerson() {
		System.out.println("Ingrese el n�mero correspondiente a su tipo de documento de identidad:"+
							"\n1.TI - Tarjeta de identidad"+
							"\n2.CC - C�dula de ciudadan�a"+
							"\n3.PP - Pasaporte"+
							"\n4.CE - C�dula de Extranjer�a");
		int type = Integer.parseInt(lector.nextLine());
		
		System.out.println("Ingrese el n�mero del documento de identificaci�n");
		String idnumber = lector.nextLine();
		
		String message="";
		message= store.registerNewPerson(type,idnumber);
		System.out.println(message);
		
	}

}
