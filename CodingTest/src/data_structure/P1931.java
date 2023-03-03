package data_structure;

/*�� ���� ȸ�ǽ��� �ִµ� �̸� ����ϰ��� �ϴ� N���� ȸ�ǿ� ���Ͽ� ȸ�ǽ� ���ǥ�� ������� �Ѵ�.
�� ȸ�� I�� ���� ���۽ð��� ������ �ð��� �־��� �ְ�, �� ȸ�ǰ� ��ġ�� �ʰ� �ϸ鼭 ȸ�ǽ��� ����� �� �ִ� ȸ���� �ִ� ������ ã�ƺ���.
��, ȸ�Ǵ� �ѹ� �����ϸ� �߰��� �ߴܵ� �� ������ �� ȸ�ǰ� ������ �Ͱ� ���ÿ� ���� ȸ�ǰ� ���۵� �� �ִ�.
ȸ���� ���۽ð��� ������ �ð��� ���� ���� �ִ�. �� ��쿡�� �������ڸ��� ������ ������ �����ϸ� �ȴ�.*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] A = new int[N][2];
		for (int i = 0; i < N; i++) {
			A[i][0] = scanner.nextInt();
			A[i][1] = scanner.nextInt();
		}
		Arrays.sort(A, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {	//����ð� ���� ����
				if(o1[1] == o2[1])	//���� �ð��� ���� �� ���� �ð� ���� ����
					return o1[0] - o2[0];
			return o1[1] - o2[1];
			}			
		});
		
		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if(A[i][0] > end-1) {
				end = A[i][1];
				count++;
			}
		}
		System.out.println(count);
		scanner.close();
	}
}