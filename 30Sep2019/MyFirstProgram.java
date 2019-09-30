import java.util.Scanner;
class MyFirstProgram{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");	
		int num= sc.nextInt();
		int fact = 1;
		for(int i = num; i>0; i--)
		{
			fact = fact * i;
		}
		System.out.println("Factorial is : "+fact);
	}
}