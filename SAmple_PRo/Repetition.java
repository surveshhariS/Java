import java.util.Scanner;

public class Repetition {
	public static void main(String args[]) {
		Scanner oo = new Scanner(System.in);
		int n = oo.nextInt();
		oo.close();
		for(int i=0; i<n; i++)   
		{   
		for(int j=1; j<=i-1; j++)   
		{   
		System.out.print("*"+" ");   
		}   
		System.out.println(); 
	}
}
}