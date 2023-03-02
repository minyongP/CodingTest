package data_structure;

/*�ر԰� ������ �ִ� ������ �� N�����̰�, ������ ������ �ſ� ���� ������ �ִ�.
������ ������ ����ؼ� �� ��ġ�� ���� K�� ������� �Ѵ�.
�̶� �ʿ��� ���� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
import java.util.Scanner;

public class P11047 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		int count = 0;
		for (int i = N-1; i >= 0; i--) {
			if(A[i] < K+1) {		//��ǥġ���� �۰ų� ���� ���̸� ī����  
				count += (K / A[i]);
				K = K % A[i];		//���� ������ K ������Ʈ
			}
		}
		System.out.println(count);
		scanner.close();
	}
}