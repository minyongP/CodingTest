package data_structure;

/*준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.*/
import java.util.Scanner;

public class P11047 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		int count = 0;
		for (int i = N-1; i >= 0; i--) {
			if(A[i] < K+1) {		//목표치보다 작거나 같은 값이면 카운팅  
				count += (K / A[i]);
				K = K % A[i];		//나눈 나머지 K 업데이트
			}
		}
		System.out.println(count);
		scanner.close();
	}
}