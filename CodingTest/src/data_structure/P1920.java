package data_structure;
//N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
//binary search
import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		Arrays.sort(A);
		int M = scanner.nextInt();
		
		//이진 탐색
		for (int i = 0; i < M; i++) {
			boolean find = false;
			int target = scanner.nextInt();
			
			int start = 0;
			int end = A.length-1;
			while (start < end+1) {
				int midi = (start + end) / 2;
				int midV = A[midi];
		
				if(midV > target)	//왼쪽 서칭
					end = midi - 1;
				else if(midV < target)	//오른쪽 서칭
					start = midi + 1;
				else {
					find = true;
					break;
				}
			}
			if(find)
				System.out.println(1);
			else 
				System.err.println(0);
			scanner.close();
		}
	}
}