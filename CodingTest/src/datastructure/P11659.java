package datastructure;
//수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하라.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11659 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int suNo = Integer.parseInt(st.nextToken());
		int quizNo = Integer.parseInt(st.nextToken());
		long[] S = new long[suNo + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < suNo+1; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		}
		for (int q = 0; q < quizNo; q++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(S[j]-S[i-1]);
		}
	}

}
