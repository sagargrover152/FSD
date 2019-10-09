class TimerThread extends Thread{
	public static void main(String[] args) {
		TimerThread t = new TimerThread();

		t.start();

	}

	public void run()
	{
		
		for (int i=0; ; i++) {
			System.out.print(i);
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