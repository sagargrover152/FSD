import java.io.*;
import java.util.Scanner;

class Exercise4{

	public static void main(String[] args) throws IOException{
		

		File myFile = new File("secondFile.txt");
		StringBuilder sb = new StringBuilder("");
 
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		String str = "";
		while((str = br.readLine()) != null)
		{
		    sb.append(str + "\n");
		}
		br.close();
		str = sb.toString();
		Scanner sc = new Scanner(System.in);
		System.out.println("what you want to replace");
		String old = sc.nextLine();
		System.out.println("Replace with what?");
		String nw = sc.nextLine();
		str = str.replaceAll(old,nw);
		BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
		bw.write(str);
		bw.flush();
		bw.close();
	}
}