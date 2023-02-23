package data_structure;
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class P2751 {
	public static int[] A, temp;
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		temp = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(1, N);
		for (int i = 1; i < N+1; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	public static void mergeSort(int s, int e){
		if(e-s<1)
			return;
		int m = s + (e - s) / 2;		// middle position
		//재귀함수 형태로 구현
		mergeSort(s,m);		//left sort
		mergeSort(m+1, e);	//right sort
		//temp save
		for (int i = s; i < e+1; i++) {
			temp[i] = A[i];
		}
		int k = s;
		int index1 = s;
		int index2 = m+1;
		// 두 그룹 병합
		// 두 그룹의 index가 가르키는 값을 비교해 더 작은 수를 선택해 배열에 저장, 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동하기
		while(index1 < m+1 && index2 <= e) {  
			if(temp[index1] > temp[index2]) {  
				A[k] = temp[index2];
				k++;
				index2++;
			}
			else {  
				A[k] = temp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) {	// 한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
			A[k] = temp[index1];
			k++;
			index1++;
		}
		while(index2 <= e) {  
			A[k] = temp[index2];
			k++;
			index2++;
		}	
	}
}