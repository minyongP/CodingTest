package data_structure;
//��� �ڿ��� N��, �� ���� ���ӵ� �ڿ����� ������ ��Ÿ�� �� �ִ�.
//����� � �ڿ��� N(1 �� N �� 10,000,000)�� ���ؼ�, �� N�� �� ���� ���ӵ� �ڿ����� ������ ��Ÿ���� �������� �˰� �;��Ѵ�.
//�̶�, ����ϴ� �ڿ����� N���Ͽ��� �Ѵ�.
//���� ���, 15�� ��Ÿ���� ����� 15, 7+8, 4+5+6, 1+2+3+4+5�� 4������ �ִ�.
//�ݸ鿡 10�� ��Ÿ���� ����� 10, 1+2+3+4�� 2������ �ִ�.
//N�� �Է¹޾� �������� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
import java.util.Scanner;
public class P2018 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int count = 1;	//�ڱ� �ڽ� ����
		int startIndex = 1;
		int endIndex = 1;
		int sum = 1;	//1���� ����
		while(endIndex!=N) {  
			if(sum==N) {
				count++;
				endIndex++;
				sum += endIndex;
			}
			else if(sum>N) {  
				sum -= startIndex;
				startIndex++;
			}
			else {  
				endIndex++;
				sum += endIndex;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}
