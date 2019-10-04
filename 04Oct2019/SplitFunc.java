import java.util.Scanner;
class SplitFunc{
	public static void main(String[] args) {
		SplitFunc obj = new SplitFunc();
		String str;
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		String word;
		word = sc.nextLine();
		String arr[] = new String[100];
		arr=obj.splitFunc(str,word);
		for(int i=0 ; i<arr.length;i++)
		{
			if(arr[i]!=null)
				System.out.println(arr[i]);
			else
				break;
		}
	}
	String[] splitFunc(String str , String word)
	{
		String temp = "";
		String arr[] = new String[100];
		int len=0, flag=0;
		for(int i = 0,j=0; i<str.length(); i++)
		{
			if(str.charAt(i)!=word.charAt(j))
			{
				temp=temp+String.valueOf(str.charAt(i));
				flag=0;
			}
			else
			{
				int ii=i,comp=1;
				for(;i<str.length()&&j<word.length();)
				{
					if(str.charAt(i)==word.charAt(j)){
						i++;
						j++;
					}
					else{
						comp=0;
						break;		
					}
				}
				if(comp==0)
				{
					temp = temp+String.valueOf(word.charAt(0));
					j=0;
					i=ii;
				}
				else
				{
					i=i-1;
					j=0;
					arr[len]=temp;
					len++;
					temp="";
					flag = 1;
				}
				
			}
		}
		if(flag==0)
			arr[len]=temp;
		return arr;
	}
}