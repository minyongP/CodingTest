package data_structure;
/*BOJ �˰��� ķ������ �� N���� �����ϰ� �ִ�.
������� 0������ N-1������ ��ȣ�� �Ű��� �ְ�, �Ϻ� ������� ģ���̴�.
������ ������ ���� ģ�� ���踦 ���� ��� A, B, C, D, E�� �����ϴ��� ���غ����� �Ѵ�.
A�� B�� ģ����.
B�� C�� ģ����.
C�� D�� ģ����.
D�� E�� ģ����.
���� ���� ģ�� ���谡 �����ϴ��� ���ϴ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
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
		int N = Integer.parseInt(st.nextToken());	//���
		int M = Integer.parseInt(st.nextToken());	//����
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
