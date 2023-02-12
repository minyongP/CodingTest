package data_structure;
/*NxN개의 수가 NxN크기의 표에 채워져 있다. 표 안의 수 중(X1,y1)에서 (X2,Y2)까지의 합을 구하려 한다.
X는 행 Y는 열을 의미한다. 예를 들어 N=4이고, 표가 다음과 같이 채워져 있을때.
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
(2,2)에서 (3,4)까지의 합은 3+4+5+4+5+6=27이고,
(4,4)에서 (4,4)까지의 합은 7이다.*/
// 시간제한상 질문횟수마다 값을 구하면 오버되기에 D배열에 미리 합값을 구한뒤 출력할때마다 계산해서 출력해줘야 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [][] A = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int [][] D = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int result = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
			System.out.println(result);
		}
	}

}
