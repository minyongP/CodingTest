package data_structure;

/*�����̴� ũ�Ⱑ N��N�� �迭 A�� �������. �迭�� ����ִ� �� A[i][j] = i��j �̴�.
�� ���� ������ �迭 B�� ������ B�� ũ��� N��N�� �ȴ�. B�� �������� �������� ��, B[k]�� ���غ���.
�迭 A�� B�� �ε����� 1���� �����Ѵ�.*/
import java.util.Scanner;

public class P1300 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		long start = 1, end = K;
		long answer = 0;
		//���� Ž��
		while(start < end+1) {  
			long middle = (start + end) / 2;
			long count = 0;
			//�߾Ӱ����� ���� �� ���
			for (int i = 1; i < N+1; i++) {
				count += Math.min(middle/i, N);	//���� ���� ī��Ʈ�ϴ� �ٽ� ����
			}
			if(count<K)
				start = middle + 1;
			else {
				answer = middle;
				end = middle - 1;
			}
		}
		System.out.println(answer);
		scanner.close();
	}
}