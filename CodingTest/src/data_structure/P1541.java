package data_structure;

/*�����̴� ����� +, -, �׸��� ��ȣ�� ������ ���� �������.
�׸��� ���� �����̴� ��ȣ�� ��� ������.
�׸��� ���� �����̴� ��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ������� �Ѵ�.
��ȣ�� ������ �ļ� �� ���� ���� �ּҷ� ����� ���α׷��� �ۼ��Ͻÿ�.*/
import java.util.Scanner;

public class P1541 {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String example = scanner.nextLine();
		String str[] = example.split("-");
		for (int i = 0; i < str.length; i++) {
			int temp = mySum(str[i]);
			if(i==0)
				answer += temp; //���� �տ� ���� ����
			else 				//�޺κ��� ���� ������ ��
				answer -= temp;
		}
		System.out.println(answer);
		scanner.close();
	}
	private static int mySum(String string) {	//���� �׷��� ���ϱ� ���� ���� �Լ�
		int sum = 0;
		String temp[] = string.split("[+]");
		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}