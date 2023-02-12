package data_structure;
//N개의 수 A1,A2,...,An이 주어졌을 때 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
//즉, Ai+...+Aj(i<j)의 합이 M으로 나누어떨어지는(i,j)쌍의 개수를 구하시오.
import java.util.Scanner;
public class P10986 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];	//M이 3이라면 나머지는 0,1,2만 나온다
		long answer=0;
		S[0] = scanner.nextLong();
		for (int i = 1; i < N; i++) {	//S에 바로 구간합 작성
			S[i] += S[i-1] + scanner.nextLong();
		}
		for (int i = 0; i < N; i++) {	//C에는 나머지 값 카운팅
			int remainder = (int)(S[i]%M);
			// 0~i 구간 합이 0일때 정답에 더하기
			if(remainder == 0) answer++;
			// 나머지가 같은 인덱스의 개수 카운팅
			C[remainder]++;
		}
		for (int i = 0; i < M; i++) {
			if(C[i]>1) {//나머지가 같은 인덱스가 2개 이상일 경우
				//나머지가 같은 인덱스 경우의 수 더하기
				answer = answer + (C[i]*(C[i]-1)/2);
			}
		}
		System.out.println(answer);
		scanner.close();
	}

}
