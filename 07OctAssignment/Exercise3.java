import java.util.Scanner;

class Exercise3{

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enetr the number to which you want to print prime numbers");
		int num = sc.nextInt();
		for(int i = 2 ; i < num; i++)
		{
			int flag = 0;
			for(int j = 2; j <= i/2; j++)
			{
				if(i%j == 0)
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0)
				System.out.print(i + " ");
		}

	}

}