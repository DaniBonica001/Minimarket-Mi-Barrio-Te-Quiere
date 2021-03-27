package model;

public class personWithTI extends Exception{
	private int type;
	
	public personWithTI(int type) {
		super();
		this.type=type;
	}
	
	@Override
	public String getMessage() {
		String message="";
		if (type==1) {
			message="Los clientes con Tarjte de identidad no pueden ingresar";
		}		
		return message;
	}

}
