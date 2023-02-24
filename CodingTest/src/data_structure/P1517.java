package data_structure;
// 합병정렬의 버블정렬
/*N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다.
이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.
버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다.
예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다.
다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다.
그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P1517 {
	public static int[] A, temp;
	public static long result=0;	//결과 값
	
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
				result = result + index2 - k;		// 뒤쪽 데이터 값이 작은 경우 업데이트
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