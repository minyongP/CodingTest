package data_structure;
// �պ������� ��������
/*N���� ���� �̷���� ���� A[1], A[2], ��, A[N]�� �ִ�.
�� ������ ���ؼ� ���� ��Ʈ�� ������ ��, Swap�� �� �� �� �߻��ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
���� ��Ʈ�� ���� ������ �ִ� �� ���� �ٲ㰡�� �����ϴ� ����̴�.
���� ��� ������ 3 2 1 �̾��ٰ� ����. �� ��쿡�� ������ �ִ� 3, 2�� �ٲ��� �ϹǷ� 2 3 1 �� �ȴ�.
�������δ� 3, 1�� �ٲ��� �ϹǷ� 2 1 3 �� �ȴ�. �������� 2, 1�� �ٲ��� �ϹǷ� 1 2 3 �� �ȴ�.
�׷��� �� �̻� �ٲ�� �� ��찡 �����Ƿ� ������ �Ϸ�ȴ�.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P1517 {
	public static int[] A, temp;
	public static long result=0;	//��� ��
	
	public static void mergeSort(int s, int e) {  
		if(e-s<1)
			return;
		int m = s + (e-s) / 2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		for (int i = s; i < e+1; i++) {
			temp[i] = A[i];
		}
		
		int k = s;
		int index1 = s;
		int index2 = m+1;
		while(index1<m+1 && index2<e+1) {  
			if(temp[index1] > temp[index2]) {  
				A[k] = temp[index2];
				result = result + index2 - k;		// ���� ������ ���� ���� ��� ������Ʈ
				k++;
				index2++;
			}
			else {  
				A[k] = temp[index1];
				k++;
				index1++;
			}
		}
		while(index1 < m+1) {  
			A[k] = temp[index1];
			k++;
			index1++;
		}
		while(index2 < e+1) {  
			A[k] = temp[index2];
			k++;
			index2++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		temp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(1, N);
		System.out.println(result);
	}
}