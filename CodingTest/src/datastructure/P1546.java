package datastructure;
import java.util.Scanner;
public class P1546 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int nums[] = new int[n];
		int sum=0;
		for (int i = 0; i < n; i++) {
			int temp = scanner.nextInt();
			sum += temp;
			nums[i] = temp;
		}
		int max=0;
		for (int i = 0; i < nums.length; i++) {
			if(max<nums[i]) {max=nums[i];}
		}
		System.out.println(sum*100.0/max/n);
		scanner.close();
	}

}