class Fibonacci{
	public static void main(String[] args) {
		System.out.print(0+" "+1+" ");
		int prev = 0;
		int next = 1;
		while(next<89)
		{	
			int temp = next;
			next = next + prev;
			System.out.print(next+" ");
			prev=temp; 
		}
	}
}