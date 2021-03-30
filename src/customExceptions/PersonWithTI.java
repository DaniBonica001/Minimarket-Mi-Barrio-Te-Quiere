package customExceptions;

@SuppressWarnings("serial")
public class PersonWithTI extends Exception{
	private int type;
	
	public PersonWithTI(int type) {
		super();
		this.type=type;
	}
	
	@Override
	public String getMessage() {
		String message="";
		if (type==1) {
			message="Los clientes con Tarjteta de identidad no pueden ingresar";
		}		
		return message;
	}

}
