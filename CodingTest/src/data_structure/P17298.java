package data_structure;
/*ũ�Ⱑ N�� ���� A = A1, A2, ..., AN�� �ִ�. ������ �� ���� Ai�� ���ؼ� ��ū�� NGE(i)�� ���Ϸ��� �Ѵ�.
Ai�� ��ū���� �����ʿ� �����鼭 Ai���� ū �� �߿��� ���� ���ʿ� �ִ� ���� �ǹ��Ѵ�. �׷��� ���� ���� ��쿡 ��ū���� -1�̴�.
���� ���, A = [3, 5, 2, 7]�� ��� NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1�̴�.
A = [9, 5, 4, 8]�� ��쿡�� NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1�̴�.*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class P17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[]ans = new int[n];
		String[]str = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(str[i]);
		}
		Stack<Integer> myStack = new Stack<>();
		myStack.push(0);	//���ʰ� Ǫ��
		for (int i = 1; i < n; i++) {
			//��ū�� ����
			while(!myStack.isEmpty() && A[myStack.peek()] < A[i]) {  
				ans[myStack.pop()] = A[i];
			}
			myStack.push(i);
		}
		//���� ���õ��� -1
		while(!myStack.empty()) {  
			ans[myStack.pop()] = -1;
		}
		//���
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}