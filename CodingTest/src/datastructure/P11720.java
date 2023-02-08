package datastructure;
import java.util.Scanner;
// N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하라.
public class P11720 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        String numString = scanner.next();
        char[] numChar = numString.toCharArray();
        int sum = 0;
        for(int i=0;i<n;i++){  
            sum += numChar[i] -'0';		//'1' - '0' = 1
        }
        System.out.print(sum);
        scanner.close();
    }
}