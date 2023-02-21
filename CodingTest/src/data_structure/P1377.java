package data_structure;
/*
bool changed = false;
for (int i=1; i<=N+1; i++) {
    changed = false;
    for (int j=1; j<=N-i; j++) {
        if (A[j] > A[j+1]) {
            changed = true;
            swap(A[j], A[j+1]);
        }
    }
    if (changed == false) {
        cout << i << '\n';
        break;
    }
}
위 소스에서 N은 배열의 크기이고, A는 정렬해야 하는 배열이다. 배열은 A[1]부터 사용한다.
위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구해보자.*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class mData implements Comparable<mData>{  
	int value;
	int index;
	
	public mData(int value, int index) {  
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o) {		//value 기준 오름차순 정렬;
		return this.value - o.value;
	}
	
}
public class P1377 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mData[]	A = new mData[N];
		for (int i = 0; i < N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(A);
		int Max = 0;
		for (int i = 0; i < N; i++) {
			if(Max < A[i].index -i)
				Max = A[i].index -1;
		}
		System.out.println(Max+1);
	}
}