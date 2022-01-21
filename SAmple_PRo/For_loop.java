import java.util.Scanner;
public class For_loop {
	public static void main(String args[]) {
		Scanner ii = new Scanner(System.in);
		int Start = ii.nextInt();
		int end = ii.nextInt();
		for (int i=Start;i<=end;i++) {
			if(i%4==0) {
			System.out.println(i);
			ii.close();
		}
	}
	}
}
