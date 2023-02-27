package data_structure;
// ���� ���� �׷����� �־����� �� ���� ����� ������ ���ϴ� ���α׷��� �ۼ�
// DFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724 {
	static ArrayList<Integer> A[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i = 1; i < N+1; i++) {			//���� ����Ʈ �ʱ�ȭ
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			//����� �����̹Ƿ� ���ʿ� ���ϱ�
			A[s].add(e);
			A[e].add(s);
		}
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			//�湮���� ���� ��尡 ���� ������ �溹
			if(!visited[i]) {  
				count++;
				dfs(i);
			}
		}
		System.out.println(count);
	}
	
	private static void dfs(int i) {
		if(visited[i])
			return;

		visited[i] = true;
		for(int j : A[i]) { 
			if(visited[j] == false)
				dfs(j);
		}
	}
}