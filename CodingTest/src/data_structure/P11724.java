package data_structure;
// 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성
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
		for (int i = 1; i < N+1; i++) {			//인접 리스트 초기화
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			//양방향 엣지이므로 양쪽에 더하기
			A[s].add(e);
			A[e].add(s);
		}
		int count = 0;
		for (int i = 1; i < N+1; i++) {
			//방문하지 않은 노드가 없을 때까지 방복
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