package data_structure;

/*세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다.
그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.*/
import java.util.Scanner;

public class P1541 {
	static int answer = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String example = scanner.nextLine();
		String str[] = example.split("-");
		for (int i = 0; i < str.length; i++) {
			int temp = mySum(str[i]);
			if(i==0)
				answer += temp; //가장 앞에 값을 더함
			else 				//뒷부분은 더한 값들을 뺌
				answer -= temp;
		}
		System.out.println(answer);
		scanner.close();
	}
	private static int mySum(String string) {	//나뉜 그룹의 더하기 연산 수행 함수
		int sum = 0;
		String temp[] = string.split("[+]");
		for (int i = 0; i < temp.length; i++) {
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}
}