package data_structure;

/*한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] A = new int[N][2];
		for (int i = 0; i < N; i++) {
			A[i][0] = scanner.nextInt();
			A[i][1] = scanner.nextInt();
		}
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {	//종료시간 기준 정렬
				if(o1[1] == o2[1])	//종료 시간이 같을 때 시작 시간 기준 정렬
					return o1[0] - o2[0];
			return o1[1] - o2[1];
			}			
		});
		
		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if(A[i][0] > end-1) {
				end = A[i][1];
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}
}