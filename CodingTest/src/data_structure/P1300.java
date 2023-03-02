package data_structure;

/*세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다.
이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.
배열 A와 B의 인덱스는 1부터 시작한다.*/
import java.util.Scanner;

public class P1300 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		long start = 1, end = K;
		long answer = 0;
		//이진 탐색
		while(start < end+1) {  
			long middle = (start + end) / 2;
			long count = 0;
			//중앙값보다 작은 수 계산
			for (int i = 1; i < N+1; i++) {
				count += Math.min(middle/i, N);	//작은 수를 카운트하는 핵심 로직
			}
			if(count<K)
				start = middle + 1;
			else {
				answer = middle;
				end = middle - 1;
			}
		}
		System.out.println(answer);
		scanner.close();
	}
}