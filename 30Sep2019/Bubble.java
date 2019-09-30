import java.util.Scanner;

class Bubble{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of elements you want to sort");
		int len = sc.nextInt();
		int arr[] = new int[len];
		System.out.println("Enter the Elements");
		for(int i = 0; i < len; i++){
			arr[i] = sc.nextInt();
		}
		for(int i = 0; i < len; i++)
		{
			for(int j = 0; j < len-i-1; j++)
			{
				if(arr[j]<arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		for(int i = 0; i < len; i++){
			System.out.print(arr[i] + " ");
		}		
	}
}