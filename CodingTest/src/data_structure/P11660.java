package data_structure;
/*NxN���� ���� NxNũ���� ǥ�� ä���� �ִ�. ǥ ���� �� ��(X1,y1)���� (X2,Y2)������ ���� ���Ϸ� �Ѵ�.
X�� �� Y�� ���� �ǹ��Ѵ�. ���� ��� N=4�̰�, ǥ�� ������ ���� ä���� ������.
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
(2,2)���� (3,4)������ ���� 3+4+5+4+5+6=27�̰�,
(4,4)���� (4,4)������ ���� 7�̴�.*/
// �ð����ѻ� ����Ƚ������ ���� ���ϸ� �����Ǳ⿡ D�迭�� �̸� �հ��� ���ѵ� ����Ҷ����� ����ؼ� �������� �Ѵ�.
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
