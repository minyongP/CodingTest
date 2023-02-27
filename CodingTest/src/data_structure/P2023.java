package data_structure;
/*�����̰� ���󿡼� ���� �����ϴ� ���� �Ҽ��̰�, ��̴� �Ҽ��� ������ ��� ���̴�.
���� �����̰� ���� �����־� �ϴ� �Ҽ��� 7331�̴�.
7331�� �Ҽ��ε�, �ű��ϰԵ� 733�� �Ҽ��̰�, 73�� �Ҽ��̰�, 7�� �Ҽ��̴�.
��, ���ʺ��� 1�ڸ�, 2�ڸ�, 3�ڸ�, 4�ڸ� �� ��� �Ҽ��̴�!
�����̴� �̷� ���ڸ� �ű��� �Ҽ���� �̸� �ٿ���.
�����̴� N�ڸ��� ���� �߿��� � ������ �ű��� �Ҽ����� �ñ�������.
N�� �־����� ��, �����̸� ���� N�ڸ� �ű��� �Ҽ��� ��� ã�ƺ���.*/

import java.util.Scanner;

public class P2023 {
	static int N;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		scanner.close();
		
		//1�� �ڸ� �Ҽ��� 4��
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}
	private static void DFS(int num, int jarisu) {
		if(jarisu == N) {
			if(isPrime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
		if(isPrime(num * 10 + i))
			DFS(num * 10 + i, jarisu + 1);
		}
	}
	
	private static boolean isPrime(int num) {
		for (int i = 2; i < num+1 / 2; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
}