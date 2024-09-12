import java.io.*;
import java.util.*;

public class Test_동적계획법_동전거스름돈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int money = Integer.parseInt(br.readLine());
		int[] dp = new int[money+1];
		
		// 동전의 종류 : 1원, 4원, 6원
		for(int i = 1; i <= money; i++) {
			int minCnt = Integer.MAX_VALUE; // 매번 항상 최솟값을 찾아주기 위해
			
			minCnt = Math.min(dp[i-1]+1, minCnt);
		}
	}
	
} // end of class
