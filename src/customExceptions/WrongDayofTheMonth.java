package customExceptions;

@SuppressWarnings("serial")
public class WrongDayofTheMonth extends Exception{
	
	private int day;
	private int idNumber;
	
	public WrongDayofTheMonth(int day,int idNumber) {
		this.day=day;
		this.idNumber=idNumber;
	}
	
	@Override
	public String getMessage() {
		String message="";
		
		if (day%2==0) {
			if (idNumber%2==0) {
				message="El pen�ltimo n�mero de tu id es "+idNumber+ " solo puedes salir los d�as impares y hoy "+day+" es d�a par";
			}			
		}else if (day%2!=0) {
			if (idNumber%2!=0) {
				message="El pen�ltimo n�mero de tu id es "+idNumber+ " solo puedes salir los d�as pares y hoy "+day+" es d�a impar";
			}
		}		
		return message;
	}

}
