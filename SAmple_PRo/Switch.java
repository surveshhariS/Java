import java.util.Scanner;
public class Switch {
	public static void main(String[] args) {
		System.out.println("1.airways = 500");
		System.out.println("2.shipment = 250");
		System.out.println("3.roadways = 100");
		Scanner oo = new Scanner(System.in);
		System.out.println("Enter your way of transport");
		int a = oo.nextInt();
		System.out.println("Enter the cargo weight");
		int b = oo.nextInt();
		
		switch(a) {
		
		case 1 :
			int Air = b*500;
			System.out.println("transport cost :"+Air);
		    break;
		case 2 :
			int Ship = b*250;
			System.out.println("transport cost :"+Ship);
			break;
		case 3 :
			int Rail = b*100;
			System.out.println("transport cost :"+Rail);
			break;
		default : 
			System.out.println("Enter the correct transport");	
		}
	}
}
