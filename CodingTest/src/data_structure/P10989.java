package data_structure;
//N���� ���� �־����� �� ������������ ����
//��� ����
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class P10989 {
	public static int A[];
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		radixSort(A, 5);							//10000 ���� �����Ƿ� �ִ� 5�ڸ���
		for (int i = 0; i < N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static void radixSort(int[] A, int maxSize) {
		int outPut[] = new int[A.length];
		int jarisu = 1;
		int count = 0;
		while(count != maxSize) {  
			int[] bucket = new int[10];				//��� �����̹Ƿ� 10ĭ
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++; 		//���� �ڸ����� ����
			}
			for (int i = 1; i < 10; i++) {			//�� �迭�� �̿��� �ε��� ���
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length-1; i >= 0; i--) {	//���� �ڸ����� �������� ����
				outPut[bucket[(A[i] / jarisu % 10)] - 1] = A[i];	//
				bucket[(A[i] / jarisu) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {	//���� �ڸ����� �̵��ϱ� ���� ���� �ڸ��� ���� ���� ������ ����
				A[i] = outPut[i];
			}
			jarisu = jarisu * 10;					// �ڸ��� ����
			count++;
		}
	}
}