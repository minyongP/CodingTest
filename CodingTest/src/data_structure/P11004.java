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
			if(pivot == K)
				return;
			else if(K < pivot)
				quickSort(A, S, pivot-1, K);
			else 
				quickSort(A, pivot+1, E, K);
		}	
	}
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
			while(pivot < A[j] && j > 0) {  
				j--;
			}
			while(pivot > A[i] && i < A.length-1) {  
				i++;
			}
			if(i<=j)
				swap(A, i++, j--);
		}
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