import com.cg.eis.exception.EmployeeException;
import java.util.Scanner;

class Exercise6{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sal = sc.nextInt();
		if(sal <= 30000)
			throw new EmployeeException();
	}

}