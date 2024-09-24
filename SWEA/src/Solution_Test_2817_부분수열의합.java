import java.io.*;
import java.util.*;


public class Solution_Test_2817_부분수열의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, K, count;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // N개의 자연수
			K = Integer.parseInt(st.nextToken()); // 그 합이 K가 되는 경우의 수
			
			count = 0;
			isVisited = new boolean[N+1];
			//result = new ArrayList<>();
			powerSet(0);
			
			sb.append("#").append(testCase).append(" ").append(count);
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void powerSet(int sum) {
		if(sum == K) {
			count++;
			return;
		}
		
		if(sum > K) {
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!isVisited[i]) {
				isVisited[i] = true;
				powerSet(sum + i);
				isVisited[i] = false;
			}
		}
	}
	
} // end of class
