package data_structure;
//�������� ����(��������)
import java.util.Scanner;
public class P1427 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int[] A = new int[str.length()];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(str.substring(i, i+1));
		}
		for (int i = 0; i < A.length; i++) {
			int max = i;
			for (int j = i+1; j < A.length; j++) {
				if(A[j] > A[max])	//���������̹Ƿ� ū���� ã�Ƽ� ������
					max = j;
			}
			if(A[i] < A[max]) {  
				int temp = A[i];
				A[i] = A[max];
				A[max] = temp;
			}
		}
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
		}
		scanner.close();
	}
}