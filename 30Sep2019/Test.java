import java.util.Scanner;
class Test{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the  First Number");	
		int first = sc.nextInt();
		System.out.println("Enter the Second Number");
		int second = sc.nextInt();
		System.out.println("Enter the Third Number");
		int third = sc.nextInt();
		int temp = 0;
		if(first >= 40)
			temp++;
		if(second >= 40)
			temp++;
		if(third >= 40)
			temp++;
		if((first+second+third)>125)
			temp++;
		if(temp==4)
			System.out.println("Passing");
		if(temp<4)
			System.out.println("Failing");
	}
}