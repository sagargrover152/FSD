import java.io.*;

class Exercise2{

	public static void main(String[] args) throws IOException{
		

		File myFile = new File("firstFile.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
		bw.write("hello how are you\n");
		bw.write("hello\n");

		bw.flush();
		bw.close();
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		String str = "";
		int lines = 0;
		while((str = br.readLine()) != null)
		{
			lines++;
		}
		br.close();


		FileReader fr = new FileReader(myFile);
		int wrds = 0;
		char[] in = new char[100];
		int chrs = fr.read(in);
		for(char i : in)
		{
			if(i == ' ' || i == '\n')
				wrds++;
		}
		fr.close(); 


		System.out.println("no of Lines are : " + lines);
		System.out.println("no of Characters are : " + chrs);
		System.out.println("no of Words are : " + wrds);
	}

}