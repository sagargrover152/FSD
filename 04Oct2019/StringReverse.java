import java.util.Scanner;
class StringReverse{
	public static void main(String[] args) {
		String str;
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		for(int j=str.length()-1;j>=0;j--)
		{
			System.out.print(str.charAt(j));
		}
	}
}