package data_structure;

import java.util.Scanner;

//�����ٸ� SJF(��������)
public class P11399 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		int[] S = new int[N];	//�� �迭
		
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}
		for (int i = 1; i < N; i++) {
			int insertPoint = i;
			int insertValue = A[i];
			for (int j = i-1; j >=0; j--) {
				if(A[j] < A[i]) {  	// j��° ���� ũ�� j ������ġ�� ��ġ
					insertPoint = j+1;
					break;
				}
				if(j == 0)			// ���� ������ �� ��
					insertPoint = 0;
			}
			for (int j = i; j > insertPoint; j--) {
				A[j] = A[j-1];
			}
			A[insertPoint] = insertValue;
		}
		
		//�� �迭
		S[0] = A[0];			
		for (int i = 1; i < N; i++) {
			S[i] = S[i-1] + A[i];
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum = sum + S[i];
		}
		
		System.out.println(sum);
		scanner.close();
	}
}