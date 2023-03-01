package data_structure;

/*N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.
1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. �̷��� �̷ΰ� �־����� ��,
(1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
�� ĭ���� �ٸ� ĭ���� �̵��� ��, ���� ������ ĭ���θ� �̵��� �� �ִ�.
���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0 , -1, 0};
	static boolean[][] visited;
	static int[][] A;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j = 0; j < M; j++) {
				A[i][j] = line.charAt(j)-'0';
			}
		}
		BFS(0,0);
		System.out.println(A[N-1][M-1]);
	}
	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});	//offer: add�� �޸� ������ �ƴ� false����
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			//��������
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x>=0 && y>=0 && x < N && y < M) {  //��ǥ ��ȿ�� �˻�
					if(A[x][y] != 0 && !visited[x][y]) {  
						visited[x][y] = true;
						A[x][y] = A[now[0]][now[1]]+1;	//���� ������Ʈ
						queue.add(new int[] {x, y});
					}
				}
			}
		}
	}
}