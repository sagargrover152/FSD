import java.util.Scanner;
class StringPalindrom{
	public static void main(String[] args) {
		String str;
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		int flag=0;
		for(int i=0,j=str.length()-1;i<j;i++,j--)
		{
			if(str.charAt(i)==str.charAt(j))
				flag=0;
			else
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
			System.out.println(str + " is not palindrom");
		else
			System.out.println(str + " is palindrom");
	}
}