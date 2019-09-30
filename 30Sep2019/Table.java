import java.util.Scanner;
class Table{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");	
		int num= sc.nextInt();
		System.out.println("Enter the limit");
		int lim = sc.nextInt();
		for(int i=1;i<=lim;i++)
		{
			System.out.println(num+" * "+i+" = "+num*i);
		}
	}
}