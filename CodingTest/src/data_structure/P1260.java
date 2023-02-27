package data_structure;
/*그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
	private static ArrayList<Integer> A[];
	private static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int startPoint = Integer.parseInt(st.nextToken());
		A = new ArrayList[node+1];
		for (int i = 1; i < node+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		//번호가 작은 것부터 방문하기 위해 정렬
		for (int i = 1; i < node+1; i++) {
			Collections.sort(A[i]);
		}
		visited = new boolean[node+1];
		DFS(startPoint);
		System.out.println();
		visited = new boolean[node+1];
		BFS(startPoint);
	}
	
	private static void DFS(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for(int i : A[node])
			if(!visited[i])
				DFS(i);
	}
	
	private static void BFS(int node) {  
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		
		while(!queue.isEmpty()) {  
			int nowNode = queue.poll();
			System.out.print(node + " ");
			for(int i : A[nowNode]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}