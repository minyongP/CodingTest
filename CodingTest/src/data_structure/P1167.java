package data_structure;
//트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

import java.util.*;

public class P1167 {
	private static boolean visited[];
	private static int[] distance;
	private static ArrayList<Edge>[] A;		//
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		A = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			A[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			int S = scanner.nextInt();
			while(true) {  
				int E = scanner.nextInt();
				if(E == -1)
					break;
				int V = scanner.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(1);
		int Max = 1;
		for (int i = 2; i < N+1; i++) {		//distance 배열에서 가장 큰 값으로 다시 시작점 설정
			if(distance[Max] < distance[i])
				Max = i;
		}
		distance = new int[N+1];
		visited = new boolean[N+1];
		BFS(Max);						//새로운 시작점 실행
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}
	private static void BFS(int index) {  
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		while(!queue.isEmpty()) {  
			int nowNode = queue.poll();
			for ( Edge i : A[nowNode]) {
				int e = i.e;
				int v = i.value;
				if(!visited[e]) {  
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[nowNode] + v;	//거리 배열 업데이트
				}
			}
		}
	}
}
class Edge{  
	int e;
	int value;
	public Edge(int e, int value) {  
		this.e = e;
		this.value = value;
	}
}