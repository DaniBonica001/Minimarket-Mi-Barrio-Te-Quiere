package model;

public class Person {
	
	//Atributes
	private Type type;
	private String idNumber;
	
	//Constructor
	public Person(Type type, String idNumber) {
		this.type=type;
		this.idNumber=idNumber;
	}
	
	//Method setter and getter	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getIdNumber() {
		return idNumber;
	}
	
	
	
	

}
