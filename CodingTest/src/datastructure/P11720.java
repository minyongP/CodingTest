package datastructure;
import java.util.Scanner;
// N���� ���ڰ� ���� ���� �� �ִ�. �� ���ڸ� ��� ���� ����϶�.
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