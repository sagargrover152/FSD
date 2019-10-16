import java.io.*;

class CopyDataThread extends Thread{

	public void run(){

		try{
			System.out.println("thread started");
			
			File oldFile = new File("source.txt");
			File newFile = new File("target.txt");
	 
			BufferedReader br = new BufferedReader(new FileReader(oldFile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
			int chr;
			int count=0;
			while((chr = br.read())!=(-1))
			{
				count++;
			    bw.write((char)chr);
			    if(count == 10){
			    	System.out.println("10 Characters printed");
			    	count=0;
			    	try{
			    		this.sleep(5000);
			    	}
			    	catch(InterruptedException ie){
			    		System.out.println(ie);
			    	}
			    }
			}
			bw.flush();
			bw.close();
			br.close();

		}
		catch(IOException io)
		{
			System.out.println(io);
		}
	}
}

class Exercise5{

	public static void main(String[] args){
		
		CopyDataThread thread = new CopyDataThread();
		thread.start();
	}
}