package data_structure;

/*N���� �� A1, A2, ..., AN�� L�� �־�����.
Di = Ai-L+1 ~ Ai ���� �ּڰ��̶�� �� ��, D�� ����� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
�̶�, i �� 0 �� Ai�� �����ϰ� D�� ���ؾ� �Ѵ�.*/
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
		//����� ���ۿ� �ְ� �� ���� ����ϱ� ���� bw ���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	//���� ����
		int slidingWindowSize = Integer.parseInt(st.nextToken());	//�����̵� ������ũ��
		st = new StringTokenizer(br.readLine());
		//��
		Deque<Node> myDeque = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
		
			//���ο� ���� ���� ������ ���� ��� ���� ������ ū ���� ������ ������ �ð� ���⵵�� ����
			
			while(!myDeque.isEmpty() && myDeque.getLast().value > now) {  
				myDeque.removeLast();
			}
			myDeque.addLast(new Node(now, i));
			//�������� ��� �� ����
			if(myDeque.getFirst().index <= i - slidingWindowSize) {  
				myDeque.removeFirst();
			}
			bw.write(myDeque.getFirst().value + " ");
		}
		bw.flush();
		bw.close();
	}
}