package data_structure;
/*�ָ��� ö�ⱺ�� �缺�ϱ� ���� ������Ʈ�� ������. �׷��� ��ö������ ���� ö�ⱺ�� ���� ������ ����� �Ͽ���.
��ö������ �ָ��� �� ������ ���Ͽ� ������ �����ϴ� �� �Ʒ��� ���� ����� �߰��ϰ� �Ǿ���.
������ ����� ������ ���� ������ ��ȣ�� ������ �ִ�.
������ �� ���� ���� ����µ� �� ����� ������ ��ȣ�� ���ļ� M(1 �� M �� 10,000,000)�� �Ǹ� ������ ����� ���� �ȴ�.
��ö������ �ڽ��� ����� �ִ� ��Ḧ ������ ������ �� ���� ���� �� �ִ��� �ñ�������.
�̷��� �ñ����� Ǯ�� �ֱ� ���Ͽ� N(1 �� N �� 15,000) ���� ���� M�� �־����� �� �� ���� ������ ���� �� �ִ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int count=0;
		int i=0;
		int j=N-1;
		while(i<j) {  
			if(A[i]+A[j] < M) {  
				i++;
			}
			else if(A[i]+A[j] > M){
				j--;
			}
			else {  
				i++;
				j--;
				count++;
			}
		}
		System.out.println(count);
		br.close();
	}
}