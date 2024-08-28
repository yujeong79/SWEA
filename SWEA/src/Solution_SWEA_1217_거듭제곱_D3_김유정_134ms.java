import java.util.Scanner;

public class Solution_SWEA_1217_거듭제곱_D3_김유정_134ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = 0;
		while(++testCase <= 10) {
			int T = sc.nextInt(); // 해당 테스트케이스의 번호

			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#"+T+" "+pow(N, M));
		} // end of testCase
		sc.close();
	} // end of main
	
	static int pow(int N, int M) {
		if(M <= 1) return N;
		
		if(M % 2 != 0) { // M이 홀수이면
			int tmp = pow(N, (M-1)/2);
			return tmp * tmp * N;
		} else {
			int tmp = pow(N, M/2);
			return tmp * tmp;
		}
	}
	
} // end of class
