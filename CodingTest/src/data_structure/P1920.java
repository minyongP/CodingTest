package data_structure;
//N���� ���� A[1], A[2], ��, A[N]�� �־��� ���� ��, �� �ȿ� X��� ������ �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�.
//binary search
import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		Arrays.sort(A);
		int M = scanner.nextInt();
		
		//���� Ž��
		for (int i = 0; i < M; i++) {
			boolean find = false;
			int target = scanner.nextInt();
			
			int start = 0;
			int end = A.length-1;
			while (start < end+1) {
				int midi = (start + end) / 2;
				int midV = A[midi];
		
				if(midV > target)	//���� ��Ī
					end = midi - 1;
				else if(midV < target)	//������ ��Ī
					start = midi + 1;
				else {
					find = true;
					break;
				}
			}
			if(find)
				System.out.println(1);
			else 
				System.err.println(0);
			scanner.close();
		}
	}
}