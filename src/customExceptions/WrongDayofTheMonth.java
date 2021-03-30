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
				message="El penúltimo número de tu id es "+idNumber+ " solo puedes salir los días impares y hoy "+day+" es día par";
			}			
		}else if (day%2!=0) {
			if (idNumber%2!=0) {
				message="El penúltimo número de tu id es "+idNumber+ " solo puedes salir los días pares y hoy "+day+" es día impar";
			}
		}		
		return message;
	}

}
