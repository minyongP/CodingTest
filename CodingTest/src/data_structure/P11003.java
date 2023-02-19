package data_structure;

/*N개의 수 A1, A2, ..., AN과 L이 주어진다.
Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오.
이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
public class P11003 {
	public static final Scanner scanner = new Scanner(System.in);
	static class Node{  
		public int value;
		public int index;
		
		Node(int value, int index){  
			this.value = value;
			this.index = index;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//출력을 버퍼에 넣고 한 번에 출력하기 위해 bw 사용
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//숫자 갯수
		int slidingWindowSize = Integer.parseInt(st.nextToken());	//슬라이딩 윈도우크기
		st = new StringTokenizer(br.readLine());
		//덱
		Deque<Node> myDeque = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
		
			//새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
			
			while(!myDeque.isEmpty() && myDeque.getLast().value > now) {  
				myDeque.removeLast();
			}
			myDeque.addLast(new Node(now, i));
			//범위에서 벗어난 값 제거
			if(myDeque.getFirst().index <= i - slidingWindowSize) {  
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
}