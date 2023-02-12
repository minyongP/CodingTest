package data_structure;
/*��ҿ� ���ڿ��� ������ ��� ���� �����ϴ� ��ȣ�� DNA ���ڿ��� �˰� �Ǿ���. DNA ���ڿ��� ��� ���ڿ��� �����ϴ� ���ڰ� {��A��, ��C��, ��G��, ��T��} �� ���ڿ��� ���Ѵ�.
���� ��� ��ACKA���� DNA ���ڿ��� �ƴ����� ��ACCA���� DNA ���ڿ��̴�.
�̷� �ź��� ���ڿ��� ������ �ŷ�� ��ȣ�� ������ DNA ���ڿ��� ����� ������� DNA ���ڿ��� �κй��ڿ��� ��й�ȣ�� ����ϱ�� �����Ծ���.
������ ��ȣ�� �̷��� ������� ū ������ �ִٴ� ���� �߰��ߴ�.
������ DNA ���ڿ��� �κй��ڿ��� �̾��� �� ��AAAA���� ���� ���ȿ� ����� ��й�ȣ�� ����� �� �� �ֱ� �����̴�.
�׷��� ��ȣ�� �κй��ڿ����� �����ϴ� ������ ������ Ư�� ���� �̻��̿��� ��й�ȣ�� ����� �� �ִٴ� ��Ģ�� �������.
������ DNA���ڿ��� ��AAACCTGCCAA�� �̰� ��ȣ�� ���� �κй��ڿ��� ���̸� 4��� ����.
�׸��� �κй��ڿ��� ��A�� �� 1�� �̻�, ��C���� 1�� �̻�, ��G���� 1�� �̻�, ��T���� 0�� �̻��� �����ؾ� ��й�ȣ�� ����� �� �ִٰ� ����.
�̶� ��ACCT�� �� ��G�� �� 1 �� �̻� �����ؾ� �Ѵٴ� ������ �������� ���� ��й�ȣ�� ������� ���Ѵ�.
������ ��GCCA�� �� ��� ������ �����ϱ� ������ ��й�ȣ�� ����� �� �ִ�.
��ȣ�� ���� ������ DNA ���ڿ��� ��й�ȣ�� ����� �κк��ڿ��� ����,
�׸��� {��A��, ��C��, ��G��, ��T��} �� ���� ��� �̻� �����ؾ� ��й�ȣ�� ����� �� �ִ��� ������� �־����� �� ��ȣ�� ���� �� �ִ� ��й�ȣ�� ������ ���� ���ϴ� ���α׷��� �ۼ�����.
�� �κй��ڿ��� �����ϴ� ��ġ�� �ٸ��ٸ� �κй��ڿ��� ���ٰ� �ϴ��� �ٸ� ���ڿ��� ����Ѵ�.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P12891 {
	static int checkArr[];	//��й�ȣ �䱸����
	static int myArr[];
	static int checkSecret;	//�䱸���� ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());	//�� ���ڿ� ����
		int P = Integer.parseInt(st.nextToken());	//�κ� ���ڿ� ����
		int result = 0;
		char A[] = new char[S];
		checkArr = new int[4];
		myArr = new int [4];
		checkSecret = 0;
		A = br.readLine().toCharArray();	//���� ���� ���ӵǰ� �Է�
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0)
				checkSecret++;	//0�̸� �ٷ� ����
		}
		for (int i = 0; i < P; i++) {	//�ʱ� P���� ��ŭ ���ڿ� ó��
			Add(A[i]);
		}
		if(checkSecret==4)
			result++;
		//sliding window
		for (int i = P; i<S; i++) {	//�ʱ� P���� ���� ��ĭ�� �̵�
			int j = i-P;
			Add(A[i]);
			Remove(A[j]);
			if(checkSecret==4)
				result++;
		}
	System.out.println(result);
	br.close();
	}
	
	private static void Add(char c) {  
		switch (c) {
		case 'A':
			myArr[0]++;
			if(myArr[0]==checkArr[0])
				checkSecret++;
			break;
			
		case 'C':
			myArr[1]++;
			if(myArr[1]==checkArr[1])
				checkSecret++;
			break;
			
		case 'G':
			myArr[2]++;
			if(myArr[2]==checkArr[2])
				checkSecret++;
			break;
			
		case 'T':
			myArr[3]++;
			if(myArr[3]==checkArr[3])
				checkSecret++;
			break;
			
		default:
			break;
		}
	}
	
	private static void Remove(char c) {  
		switch (c) {
		case 'A':
			if(myArr[0]==checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
			
		case 'C':
			if(myArr[1]==checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
			
		case 'G':
			if(myArr[2]==checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
			
		case 'T':
			if(myArr[3]==checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
			
		default:
			break;
		}
	}
}