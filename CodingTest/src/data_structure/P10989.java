package data_structure;
//N개의 수가 주어졌을 때 오름차순으로 정렬
//기수 정렬
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
		
		radixSort(A, 5);							//10000 보다 작으므로 최대 5자리수
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
			int[] bucket = new int[10];				//기수 정렬이므로 10칸
			for (int i = 0; i < A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++; 		//일의 자리부터 시작
			}
			for (int i = 1; i < 10; i++) {			//합 배열을 이용해 인덱스 계산
				bucket[i] += bucket[i - 1];
			}
			for (int i = A.length-1; i >= 0; i--) {	//현재 자릿수를 기준으로 정렬
				outPut[bucket[(A[i] / jarisu % 10)] - 1] = A[i];	//
				bucket[(A[i] / jarisu) % 10]--;
			}
			for (int i = 0; i < A.length; i++) {	//다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터 저장
				A[i] = outPut[i];
			}
			jarisu = jarisu * 10;					// 자릿수 증가
			count++;
		}
	}
}