import java.util.Scanner;

class Exercise2{

	public static void main(String[] args) {

		System.out.println("Enter the number of value you want to print in Fabonacci series ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.print(1 + " ");
		System.out.print(1 + " ");
		int first = 1;
		int second = 1;
		for(int i = 2; i < num; i++){
			int sum = first + second;
			System.out.print(sum + " ");
			first = second;
			second = sum;
		}
	}
}