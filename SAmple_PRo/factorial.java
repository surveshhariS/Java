import java.util.Scanner;

 class factorial {
	 		  static void fac(int n) {
	 			 int fact = 1;
	 			for( int i=1;i<=n;i++) {
	 				fact=fact*i;
	 			}
	 			System.out.println(fact);
	 		}
	 		
	 		public static void main(String[]args) {
	 			Scanner ii = new Scanner(System.in);
	 			int n = ii.nextInt();
	 			fac(n);
	 		}
}
