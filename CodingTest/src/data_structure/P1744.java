package data_structure;

/*���̰� N�� ������ �־����� ��, �� ������ ���� ���Ϸ��� �Ѵ�.
������, �׳� �� ������ ���� ��� ���ؼ� ���ϴ� ���� �ƴ϶�, ������ �� ���� �������� �Ѵ�. � ���� �������� �� ��, ��ġ�� ������� ���� �� �ִ�.
������, ���� ��ġ�� �ִ� ��(�ڱ� �ڽ�)�� ���� ���� �Ұ����ϴ�. �׸��� � ���� ���� �Ǹ�, ������ ���� ���� �� ���� ���� ���� ���� �Ŀ� ���Ѵ�.
���� ���, � ������ {0, 1, 2, 4, 3, 5}�� ��, �׳� �� ������ ���� ���ϸ� 0+1+2+4+3+5 = 15�̴�. ������, 2�� 3�� ����, 4�� 5�� ���� �Ǹ�, 0+1+(2*3)+(4*5) = 27�� �Ǿ� �ִ밡 �ȴ�.
������ ��� ���� �� �ѹ��� ���ų�, �ƴϸ� ���� �ʾƾ��Ѵ�. ������ �־����� ��, ������ �� ���� ������ ������ ��, �� ���� �ִ밡 �ǰ� �ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1744 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());	//�迭 �������� ����
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
		while(plusQueue.size()>1) {  	//���ó��
			int first = plusQueue.remove();
			int second = plusQueue.remove();
			sum += first*second;
		}
		if(!plusQueue.isEmpty()) {		//������ ���� �ϳ��� �ִٸ� ����
			sum += plusQueue.remove();
		}
		while(minusQueue.size()>1) {  	//����ó��
			int first = minusQueue.remove();
			int second = minusQueue.remove();
			sum += first*second;
		}
		if(!minusQueue.isEmpty()) {
			if(zero == 0)				//0�� �ִٸ� ���� ���� �ϳ��� ���� ���ٸ� ����
				sum += minusQueue.remove();
		}
		sum += one;						// 1 ó��
		System.out.println(sum);
		scanner.close();
	}
}