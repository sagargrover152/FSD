import java.io.*;
import java.util.Scanner;
class Exercise3{

	public static void main(String[] args) throws IOException{
		
		Scanner sc =  new Scanner(System.in);
		String filename = sc.nextLine();
		File myFile = new File(filename);
		System.out.println("Can Read : " + myFile.canRead());
		System.out.println("Can Write : " + myFile.canWrite());
		System.out.println("Exists : " + myFile.exists());
		System.out.println("Type of file : " + org.apache.commons.io.FilenameUtils.getExtension(filename));
		System.out.println("length of file : " + myFile.length());

	}

}