import java.util.Arrays;

public class squareSums {
	
	public static int total=200;
	
	public static void SquareSum(int lowLimit, int curSum, int[] values, int valueIndex) {
		if (curSum<total) {
			for (int i=lowLimit; i<Math.sqrt(total-curSum)+1; i++) {
				curSum+=i*i;
				values[valueIndex]=i;
				valueIndex++;
				SquareSum(i+1, curSum, values, valueIndex);
				curSum-=i*i;
				valueIndex--;
				values[valueIndex]=0;
			}
		} else if (curSum==total) {
			for (int i=0; i<valueIndex; i++) {
				System.out.print(values[i]+((i==valueIndex-1)?"^2":"^2 + "));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] values=new int[20];
		SquareSum(1, 0, values, 0);
	}
}