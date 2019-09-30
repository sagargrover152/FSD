import java.util.Scanner;
class DecToBin{
	public static void main(String[] args) {
		System.out.println("Enter the Number");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int rem;
		String bin = "";
		while(num>0)
		{
			rem=num%2;
			bin+=Integer.toString(rem);
			num=num/2;
		}
		for(int i = bin.length()-1;i>=0;i--)
		{
			System.out.print(bin.charAt(i));
		}
	}
}