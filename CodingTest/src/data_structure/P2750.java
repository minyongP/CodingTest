package data_structure;
//N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
import java.util.Scanner;
public class P2750 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int A[] = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}
		//buble sort
		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < N-1-i; j++) {
				if(A[j] > A[j+1]) {  
					int temp = A[j+1];
					A[j+1] = A[j];
					A[j] = temp;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]+" ");
		}
		scanner.close();
	}
}