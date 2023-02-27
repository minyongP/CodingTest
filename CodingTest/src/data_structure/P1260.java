package data_structure;
/*�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�,
�� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.*/
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
		//��ȣ�� ���� �ͺ��� �湮�ϱ� ���� ����
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