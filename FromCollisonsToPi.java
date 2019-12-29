import java.util.Scanner;

public class FromCollisonsToPi {
						
	public static void posSpeedPrinter() {
		System.out.printf("Position of 1st object is %.3f\n", x1);
		System.out.printf("Velocity of 1st object is %.3f\n\n", V1);
		System.out.printf("Position of 2st object is %.3f\n", x2);
		System.out.printf("Velocity of 2st object is %.3f", V2);
	}
		
	public static void posSpeedUpd(double dt) {
		x1+=V1*dt;
		x2+=V2*dt;
		tTotal+=dt;
	}
		
	public static void postCollisonSpeedUpd() {
		//update speeds according to elastic collison formula in physics
		double tempV1=V1;
		V1=V1*(m1-m2)/(m1+m2) + 2*m2*V2/(m1+m2);
		V2=2*m1*tempV1/(m1+m2) + (m2-m1)*V2/(m1+m2);
		}
			
	public static void checker() {
		//if (1st object moving left => V1<0)
		if (V1<0) {
			double dt = -x1/V1;
			posSpeedUpd(dt);
			V1=-V1;
			counter++;
		}	
		//else if (1st moving right, they will collide => V1>V2)
		else if (V1>V2) {
			double Vtotal = V1-V2;
			double distance = x2-x1;
			double dt= distance/Vtotal;
			posSpeedUpd(dt);
			postCollisonSpeedUpd();
			counter++;
		}
		//else (both moving right, V2>V1 therefore no collison)
		else if (V2>0 && V1>0 && V2>V1) {
			System.out.println("That's it");
		}
		//Failsafe
		else {
			System.out.println("Something went wrong");
			posSpeedPrinter();
		}
	}
	
	public static double m1=1;
	public static double x1;
	public static double V1;
			
	public static double m2;
	public static double x2;
	public static double V2;
	
	public static double counter;
	public static double tTotal;
	
	public static void initializer(int digit) {
		m2=Math.pow(100, digit);
		counter=0;
		tTotal=0;
		x1=1;
		V1=0;
		x2=2;
		V2=-1;
		while (!(V2>=0 && V1>=0 && V2>V1)) {
			checker();
		}
		System.out.printf("When digit equals %d, pi is %.0f;\n", digit, counter);
		posSpeedPrinter();
		System.out.printf("\nIt took %.3f seconds", tTotal);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to FromCollisonsToPi!\nThis program calculates pi through colliding two blocks next to a wall and counting the number of collisions.\nOtutput will consist of pi, position and velocity values of the two blocks in the end.\n");
		System.out.println("Please enter how many digits of pi you would like to calculate \n(Mind that it takes a long time to calculate 10 or more digits): ");
		int digit = console.nextInt();
		for (int i=0; i<=digit; i++) {
			initializer(i);
			String block = ((i==digit) ? "":"----------------------------");
			System.out.println(block);
		}
		
	}
}
