import java.util.Scanner;

class AgeValidateException extends RuntimeException{

	String ageNotValid(){
		return "First Name and Last Name cant be empty";
	}
}
class Exercise5{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		if(age<15)
			throw new AgeValidateException();
	}
}