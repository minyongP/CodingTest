package data_structure;
/*N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
수의 위치가 다르면 값이 같아도 다른 수이다.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		long arrs[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arrs[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arrs);
		for (int k = 0; k < n; k++) {	// 좋은수 k
			long find = arrs[k];
			int i=0;
			int j=n-1;
			//twoPointer
			while(i<j) {  
				if(arrs[i] + arrs[j] == find) {  
					if(i != k && j != k) {  
						result++;
						break;
					}
					else if(i == k) {  
						i++;
					}
					else if(j == k) {  
						j--;
					}
				}
				else if(arrs[i] + arrs[j] < find) {  
					i++;
				}
				else {  // > find
					j--;
				}
			}
		}
		System.out.println(result);
		br.close();
	}
}