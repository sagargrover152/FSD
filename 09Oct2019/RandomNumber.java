import java.util.Date;

class RandomNumber extends Thread{
	public static void main(String[] args) throws InterruptedException{
		RandomNumber t = new RandomNumber();
		RandomNumber t1 = new RandomNumber();
             

		t.start();


	}

	public void run()
	{
		for (; ;) {
			Date d = new Date();
			long time = d.getTime();
			System.out.print(((time%13211)/2)*9);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				System.out.println("exception");
			}
			System.out.print("\r");
		}
	}
}