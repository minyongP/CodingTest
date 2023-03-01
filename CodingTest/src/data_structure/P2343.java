package data_structure;

/*강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다. 블루레이에는 총 N개의 강의가 들어가는데,
블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다. 순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다.
즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.
강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다.
오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다. 이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다.
단, M개의 블루레이는 모두 같은 크기이어야 한다. 강토의 각 강의의 길이가 분 단위(자연수)로 주어진다.
이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.*/
import java.util.Scanner;

public class P2343 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
			if(start < A[i]) start = A[i];		//레슨 최댓값을 시작 인덱스로 저장
			end += A[i];						//모든 레슨의 총 합을 종료 인덱스로 저장
		}
		
		while(start < end+1) {  
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < A.length; i++) {	//mid 값으로 모든 레슨을 저장할 수 있는지 확인
				if(sum + A[i] > mid) { 
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if(sum != 0)
				count++;
			if(count > M)			// 크기(start)인 M개로 저장 불가능 start + 1
				start = mid + 1;
			else  					// 크기(end)인 M개로 저장 가능 end -1
				end = mid - 1;
		}
		System.out.println(start);
		scanner.close();
	}
}