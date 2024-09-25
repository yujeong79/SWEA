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
			powerSet(0);
			
			sb.append("#").append(testCase).append(" ").append(count);
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void powerSet(int idx) {
		if(idx == N) {
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				if(isVisited[i])
					list.add(i+1);
			}
			System.out.println(list.toString());
			return;
		}
		
		isVisited[idx] = true;
		powerSet(idx+1);
		
		isVisited[idx] = false;
		powerSet(idx+1);
		
	}
	
} // end of class
