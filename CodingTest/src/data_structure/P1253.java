package data_structure;
/*N���� �� �߿��� � ���� �ٸ� �� �� ���� ������ ��Ÿ�� �� �ִٸ� �� ���� ������(GOOD)���� �Ѵ�.
N���� ���� �־����� �� �߿��� ���� ���� ������ �� ������ ����϶�.
���� ��ġ�� �ٸ��� ���� ���Ƶ� �ٸ� ���̴�.*/
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
		for (int k = 0; k < n; k++) {	// ������ k
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