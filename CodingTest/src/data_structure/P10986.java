package data_structure;
//N���� �� A1,A2,...,An�� �־����� �� ���ӵ� �κ��� ���� M���� ����������� ������ ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
//��, Ai+...+Aj(i<j)�� ���� M���� �����������(i,j)���� ������ ���Ͻÿ�.
import java.util.Scanner;
public class P10986 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		long[] S = new long[N];
		long[] C = new long[M];	//M�� 3�̶�� �������� 0,1,2�� ���´�
		long answer=0;
		S[0] = scanner.nextLong();
		for (int i = 1; i < N; i++) {	//S�� �ٷ� ������ �ۼ�
			S[i] += S[i-1] + scanner.nextLong();
		}
		for (int i = 0; i < N; i++) {	//C���� ������ �� ī����
			int remainder = (int)(S[i]%M);
			// 0~i ���� ���� 0�϶� ���信 ���ϱ�
			if(remainder == 0) answer++;
			// �������� ���� �ε����� ���� ī����
			C[remainder]++;
		}
		for (int i = 0; i < M; i++) {
			if(C[i]>1) {//�������� ���� �ε����� 2�� �̻��� ���
				//�������� ���� �ε��� ����� �� ���ϱ�
				answer = answer + (C[i]*(C[i]-1)/2);
			}
		}
		System.out.println(answer);
		scanner.close();
	}

}
