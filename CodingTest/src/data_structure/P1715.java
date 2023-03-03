package data_structure;

/*���ĵ� �� ������ ���� ī�尡 �ִٰ� ����. �� ������ ī���� ���� A, B�� �ϸ� ���� �� ������ ���ļ� �ϳ��� ����� ������ A+B ���� �񱳸� �ؾ� �Ѵ�.
 * �̸��׸�, 20���� ���� ī�� ������ 30���� ���� ī�� ������ ��ġ���� 50���� �񱳰� �ʿ��ϴ�.
�ſ� ���� ���� ī�� ������ å�� ���� ���� �ִ�. �̵��� �� ������ ��� ���� ���ĳ����ٸ�, ���� ������ ���� �� Ƚ���� �ſ� �޶�����.
���� ��� 10��, 20��, 40���� ������ �ִٸ� 10��� 20���� ��ģ ��, ��ģ 30�� ������ 40���� ��ģ�ٸ� (10 + 20) + (30 + 40) = 100���� �񱳰� �ʿ��ϴ�.
�׷��� 10��� 40���� ��ģ ��, ��ģ 50�� ������ 20���� ��ģ�ٸ� (10 + 40) + (50 + 20) = 120 ���� �񱳰� �ʿ��ϹǷ� �� ȿ������ ����̴�.
N���� ���� ī�� ������ ������ ũ�Ⱑ �־��� ��, �ּ��� �� ���� �񱳰� �ʿ������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			queue.add(scanner.nextInt());
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (queue.size() != 1) {
			data1 = queue.remove();
			data2 = queue.remove();
			sum += data1 + data2;
			queue.add(data1 + data2);
		}
		System.out.println(sum);
		scanner.close();
	}
}