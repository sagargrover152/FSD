import java.util.Scanner;

class Exercise2b{

	public static void main(String[] args) {

		System.out.println("Enter the number of value you want to print in Fabonacci series ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.print(1 + " ");
		System.out.print(1 + " ");
		int first = 1;
		int second = 1;
		new Exercise2b().Fabonacci(first,second,num);

	}

	int Fabonacci(int first , int second, int num){

		if(num == 2){
			return 0;
		}
		int sum = first + second;
		System.out.print(sum + " ");
		first = second;
		second = sum;
		num--;
		Fabonacci(first,second,num);
		return 1;
	}

}