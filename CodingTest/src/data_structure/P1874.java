package data_structure;
/*���� (stack)�� �⺻���� �ڷᱸ�� �� �ϳ���, ��ǻ�� ���α׷��� �ۼ��� �� ���� �̿�Ǵ� �����̴�.
������ �ڷḦ �ִ� (push) �Ա��� �ڷḦ �̴� (pop) �Ա��� ���� ���� ���߿� �� �ڷᰡ ���� ���� ������ (LIFO, Last in First out) Ư���� ������ �ִ�.
1���� n������ ���� ���ÿ� �־��ٰ� �̾� �þ�������ν�, �ϳ��� ������ ���� �� �ִ�.
�̶�, ���ÿ� push�ϴ� ������ �ݵ�� ���������� ��Ű���� �Ѵٰ� ����.
������ ������ �־����� �� ������ �̿��� �� ������ ���� �� �ִ��� ������, �ִٸ� � ������ push�� pop ������ �����ؾ� �ϴ����� �˾Ƴ� �� �ִ�.
�̸� ����ϴ� ���α׷��� �ۼ��϶�.*/
import java.util.Scanner;
import java.util.Stack;
public class P1874 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		int num=1;
		boolean result = true;
		for (int i = 0; i < A.length; i++) {
			int su = A[i];
			if(su >= num) {  
				while(su >= num) {  
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			}
			else {  
				int n = stack.pop();
				if(n > su) {  
					System.out.println("NO");
					result = false;
					break;
				}
				else {  
					sb.append("-\n");
				}
			}
		}
		if(result) System.out.println(sb.toString());
		scanner.close();
	}
}