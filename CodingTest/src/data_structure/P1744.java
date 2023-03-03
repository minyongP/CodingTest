package data_structure;

/*길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다.
하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다.
하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다. 수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.*/
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());	//배열 내림차순 정렬
		PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
		int one = 0;
		int zero = 0;
		for (int i = 0; i < N; i++) {
			int data = scanner.nextInt();
			if(data>1)
				plusQueue.add(data);
			else if(data == 1)
				one++;
			else if(data == 0)
				zero++;
			else if(data < 0)
				minusQueue.add(data);
			else
				return;
		}
		int sum = 0;
		while(plusQueue.size()>1) {  	//양수처리
			int first = plusQueue.remove();
			int second = plusQueue.remove();
			sum += first*second;
		}
		if(!plusQueue.isEmpty()) {		//마지막 남은 하나가 있다면 덧셈
			sum += plusQueue.remove();
		}
		while(minusQueue.size()>1) {  	//음수처리
			int first = minusQueue.remove();
			int second = minusQueue.remove();
			sum += first*second;
		}
		if(!minusQueue.isEmpty()) {
			if(zero == 0)				//0이 있다면 남은 음수 하나와 곱셈 없다면 덧셈
				sum += minusQueue.remove();
		}
		sum += one;						// 1 처리
		System.out.println(sum);
		scanner.close();
	}
}