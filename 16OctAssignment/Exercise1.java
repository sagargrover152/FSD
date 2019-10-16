import java.io.*;

class Exercise1{

	public static void main(String[] args) throws IOException{
		
		File myFile = new File("firstFile.txt");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
		// bw.write("hello i am writing my first filewith the help of bufferedwriter class \n");
		// bw.write("hello i am writing my first filewith the help of bufferedwriter class \n");
		// bw.write("hello i am writing my first filewith the help of bufferedwriter class \n");
		// bw.write("hello i am writing my first filewith the help of bufferedwriter class \n");
		// bw.write("hello i am writing my first filewith the help of bufferedwriter class \n");
		// bw.flush();
		// bw.close();
		BufferedReader br = new BufferedReader(new FileReader(myFile));
		String str = "";
		int count = 0;
		while((str = br.readLine()) != null)
		{
			System.out.print((count+1) + " ");
			count++;
		    System.out.println(str);
		}
		br.close();
	}
	
}