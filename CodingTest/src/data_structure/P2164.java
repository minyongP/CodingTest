package data_structure;
/*N���� ī�尡 �ִ�. ������ ī��� ���ʷ� 1���� N������ ��ȣ�� �پ� ������, 1�� ī�尡 ���� ����, N�� ī�尡 ���� �Ʒ��� ���·� ������� ī�尡 ���� �ִ�.
���� ������ ���� ������ ī�尡 �� �� ���� ������ �ݺ��ϰ� �ȴ�. �켱, ���� ���� �ִ� ī�带 �ٴڿ� ������. �� ����, ���� ���� �ִ� ī�带 ���� �Ʒ��� �ִ� ī�� ������ �ű��.
���� ��� N=4�� ��츦 ������ ����. ī��� ���� ���������� 1234 �� ������ �����ִ�. 1�� ������ 234�� ���´�. ���⼭ 2�� ���� �Ʒ��� �ű�� 342�� �ȴ�.
3�� ������ 42�� �ǰ�, 4�� ������ �ű�� 24�� �ȴ�. ���������� 2�� ������ ����, ���� ī��� 4�� �ȴ�.
N�� �־����� ��, ���� �������� ���� �Ǵ� ī�带 ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class P2164 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = scanner.nextInt();
		
		for (int i = 1; i < N+1; i++) {
			myQueue.add(i);
		}
		
		while (myQueue.size()>1) {
			myQueue.poll();
			myQueue.add(myQueue.poll());
		}
		System.out.println(myQueue.poll());
		scanner.close();
	}
}