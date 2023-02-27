package data_structure;
/*BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다.
사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P13023 {
	private static ArrayList<Integer> A[];
	private static boolean visited[];
	private static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//노드
		int M = Integer.parseInt(st.nextToken());	//엣지
		arrive = false;
		A = new ArrayList[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			A[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		for (int i = 0; i < N; i++) {
			DFS(i, 1);
			if(arrive)
				break;
		}
		
		if(arrive)
			System.out.println("1");
		else  
			System.out.println("0");
	}
	
	private static void DFS(int now, int depth) {
		if(depth == 5 || arrive) {  
			arrive = true;
			return;
		}
		visited[now] = true;
		for(int i : A[now])
			if(!visited[i])
				DFS(now, depth+1);
		visited[now] = false;
	}

}
