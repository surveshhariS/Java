import java.util.Scanner;

public class Prime {
	public static void main(String args[]) {
		Scanner pp = new Scanner(System.in);
		int n = pp.nextInt();
		for ( int i=0;i<=n;i++) {
			int j=2;
			boolean isPrime = true;
			if(i==0 || i==1)  isPrime = false; 
			 else {
			 	 while(j<i) {
				 	if(i%j==0) isPrime=false;
			 		j++;
				 }
			 }
			if(isPrime) System.out.println(i); 
		 }
	 }
}
