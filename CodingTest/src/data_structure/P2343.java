package data_structure;

/*����� �ڽ��� ��Ÿ ���� �������� ��緹�̷� ����� �Ǹ��Ϸ��� �Ѵ�. ��緹�̿��� �� N���� ���ǰ� ���µ�,
��緹�̸� ��ȭ�� ��, ������ ������ �ٲ�� �� �ȴ�. ������ �ڹٲ�� ��쿡�� ������ �帧�� ����, �л����� ��ȥ���� ���� �� �ֱ� �����̴�.
��, i�� ���ǿ� j�� ���Ǹ� ���� ��緹�̿� ��ȭ�Ϸ��� i�� j ������ ��� ���ǵ� ���� ��緹�̿� ��ȭ�ؾ� �Ѵ�.
����� �� ��緹�̰� �󸶳� �ȸ��� ���� �� �� ���� ������, ��緹���� ������ ������ ���̷��� �Ѵ�.
���� ��� ���� ����� M���� ��緹�̿� ��� ��Ÿ ���� �������� ��ȭ�ϱ�� �ߴ�. �̶�, ��緹���� ũ��(��ȭ ������ ����)�� �ּҷ� �Ϸ��� �Ѵ�.
��, M���� ��緹�̴� ��� ���� ũ���̾�� �Ѵ�. ������ �� ������ ���̰� �� ����(�ڿ���)�� �־�����.
�̶�, ������ ��緹���� ũ�� �� �ּҸ� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
import java.util.Scanner;

public class P2343 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
			if(start < A[i]) start = A[i];		//���� �ִ��� ���� �ε����� ����
			end += A[i];						//��� ������ �� ���� ���� �ε����� ����
		}
		
		while(start < end+1) {  
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < A.length; i++) {	//mid ������ ��� ������ ������ �� �ִ��� Ȯ��
				if(sum + A[i] > mid) { 
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if(sum != 0)
				count++;
			if(count > M)			// ũ��(start)�� M���� ���� �Ұ��� start + 1
				start = mid + 1;
			else  					// ũ��(end)�� M���� ���� ���� end -1
				end = mid - 1;
		}
		System.out.println(start);
		scanner.close();
	}
}