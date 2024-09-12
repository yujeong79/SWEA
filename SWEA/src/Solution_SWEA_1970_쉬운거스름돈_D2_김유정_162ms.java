import java.io.*;
import java.util.*;

public class Solution_SWEA_1970_쉬운거스름돈_D2_김유정_162ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] balance = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			sb.append("#" + testCase + "\n");
			
			int N = Integer.parseInt(br.readLine().trim());
			int[] count = new int[8];
			
			int bi = 0; // balance의 인덱스
			while(bi <= 7) {
				count[bi] = N/balance[bi];
				sb.append(count[bi] + " ");
				N %= balance[bi];
				bi++;
			}
			sb.append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class
