package data_structure;
/*스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
이를 계산하는 프로그램을 작성하라.*/
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