import java.util.Scanner;

class NameValidateException extends RuntimeException{

	String nameNotValid(){
		return "First Name and Last Name cant be empty";
	}
}
class Exercise4{

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String firstName = sc.nextLine();
		String lastName = sc.nextLine();
		if(firstName.length()==0 || lastName.length()==0)
			throw new NameValidateException();
	}
}