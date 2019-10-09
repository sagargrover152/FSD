import java.util.Scanner;

class AgeValidateException extends RuntimeException{

	String ageNotValid(){
		return "Age is less than 15";
	}
}
class Exercise5{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age<15){
			try{
				throw new AgeValidateException();
			}
			catch(AgeValidateException ave){
				System.out.println(ave.ageNotValid());
			}
		}
	}
}
