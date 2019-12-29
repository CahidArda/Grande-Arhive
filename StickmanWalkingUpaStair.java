import java.util.Scanner;

public class StickmanWalkingUpaStair {
	/*
	 * Pre-coded for loop to make it easier and shorter to code print commands.
	 * It takes a string (a) and integer (count) and prints the given string for given amount.
	 */
	public static void printer(String a, int count) {
		for (int i=1; i<=count; i++) {
			System.out.print(a);
		}
	}
	
	/*
	 * Method to produce the stair output. Method used in order to decrease redundancy.
	 * Prints spaces for given amount, then the step, then prints stars for given amount,
	 * then ends the stair and goes to the new line. 
	 * Since number of stars and spaces varies, parameters will be used.
	 */
	public static void stairPrinter(int numSpaces, int numStars) {
		printer("   ", numSpaces);
		System.out.print("___|");
		printer("***", numStars);
		System.out.print("|\n");
	}
	
	/* 
	 * Output the head and hands, print the part of the body that isn't followed up by a stair.
	 * int curStep is explained above main method.
	 */
	public static void top(int curStep, int stickmanHeight, int stairHeight) {
		printer("   ", curStep);
		System.out.print(" O \n");
		printer("   ", curStep);
		System.out.print("/|\\\n");
		/*For loop evaluates the numbers to see if there is a line with "|" but no stair, prints it if there is one*/
		for (int i=1; i<=stickmanHeight-stairHeight+curStep-3; i++) {
			printer("   ", curStep);
			System.out.print(" | \n");
		}
	}
	
	/* 
	 * Print lines where both body and the stair exists.
	 * int curStep and curLine explained above main method.
	 */
	public static void middle(int curStep, int stickmanHeight, int stairHeight) {
		/*For loop prints necessary amounts of spaces, prints the body and creates the stair.*/
		for (int curLine=1; curLine<=stairHeight-curStep; curLine++) {
			printer("   ", curStep);
			System.out.print(" | ");
			stairPrinter(stairHeight-curStep-curLine+1, curLine-1);
		}
		/*Following part prints the last line containing stickman.*/
		printer("   ", curStep);
		System.out.print("/ \\");
		stairPrinter(0, stairHeight-curStep);
	}
	
	/*
	 * Print lines where only the stair exists.int curStep and curLine explained above main method.
	 */
	public static void bottom(int curStep, int stickmanHeight, int stairHeight) {
		for (int curLine=stairHeight-curStep+1; curLine<=stairHeight; curLine++) {
			stairPrinter(stairHeight-curLine+1, curLine);
		}
	}

	public static int[]  initializer() {
		Scanner console = new Scanner(System.in);
		System.out.println("Height of the stickman: ");
		int stickmanHeight = console.nextInt();
		System.out.println("Height of the stair: ");
		int stairHeight = console.nextInt();
		int[] result = {stickmanHeight, stairHeight};
		return(result);
	}
	
	/*
	 * int curStep is a counter referring to where the stickman is.
	 * Since stickman is in front of the stair at the beginning, curStep starts with 0.
	 * curStep is increased as further frames are being printed
	 * int curLine is another counter and it refers to the individual line which is being printed within the frame.
	 * It was necessary when calculating the parameters of stairPrinter method which are the number of spaces and stars.
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to StickmanWalkingUpaStair, \nA program coded by a humble computer science student who is taking his first steps and has no creativity to name his program");
		System.out.println("Height of the stickman has to be at least 2 higher than the stair, please mind this when you are inputting values.\n");
		int[] input = initializer();
		while (!(input[1]+2<=input[0])) {
			System.out.println("Stickman's height has to be at least 2 higher then stair");
			input = initializer();
		}
		int stairHeight=input[1];
		int stickmanHeight=input[0];
		/*
		 * Procedure for every frame:
		 * Lines are left empty if necessary
		 * The parts of the stickman which are sticking out (or lines with stickman and without stair) are printed
		 * Lines with stickman and stair are printed. Stickman is completed
		 * Rest of the stair is printed
		 * 3 empty lines are printed
		 */
		for (int curStep=0; curStep<=stairHeight; curStep++) {
			printer("\n", stairHeight-curStep);
			top(curStep, stickmanHeight, stairHeight);
			middle(curStep, stickmanHeight, stairHeight);
			bottom(curStep, stickmanHeight, stairHeight);
			printer("\n", 3);
		}
	}	
}
