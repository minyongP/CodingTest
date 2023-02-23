package data_structure;
//수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P11004 {
	public static void quickSort(int A[], int S, int E, int K) {  
		if(S<E) {  
			int pivot = partition(A, S, E);
			if(pivot == K)								// K 번째 수가 pivot이면 더 이상 구할 필요 없음
				return;
			else if(K < pivot)							// K가 pivot보다 작으면 왼쪽만 정렬
				quickSort(A, S, pivot-1, K);
			else 										// K가 pivot보다 크면 오른쪽만 정렬
				quickSort(A, pivot+1, E, K);
		}	
	}
	//퀵정렬
	public static int partition(int A[], int S, int E) {  
		if(S+1 == E) {  
			if(A[S] > A[E])
				swap(A,S,E);
			return E;
		}
		int M = (S + E) / 2;	//가운데 값을 피벗으로
		swap(A, S, M);			// i, j를 쉽게 잡기위해 피벗을 맨 앞으로
		int pivot = A[S];
		int i = S+1, j = E;
		while(i<=j) {  
			while(pivot < A[j] && j > 0) {  		//pivot보다 작은 수가 나올 때까지
				j--;
			}
			while(pivot > A[i] && i < A.length-1) {  //pivot보다 큰 수가 나올 때까지
				i++;
			}
			if(i<=j)
				swap(A, i++, j--);
		}
		// i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정
		A[S] = A[j];
		A[j] = pivot;
		return j;
	}
	public static void swap(int A[], int i, int j) {  
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(A, 0, N-1, K-1);
		System.out.println(A[K-1]);
	}
}