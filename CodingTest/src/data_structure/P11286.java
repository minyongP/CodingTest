package data_structure;
/*절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
배열에 정수 x (x ≠ 0)를 넣는다.
배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class P11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2)->{  
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs)		//절댓값이 같으면 음수 우선
				return o1>o2 ? 1:-1;		
			return first_abs - second_abs;	//절대값이 다르면 작은순 정렬
		});
		
		for (int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {  
				if(myQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(myQueue.poll());
			}
			else {
				myQueue.add(request);
			}
		}
	}
}