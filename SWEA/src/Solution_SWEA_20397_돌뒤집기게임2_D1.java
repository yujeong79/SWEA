import java.io.*;
import java.util.*;

public class Solution_SWEA_20397_돌뒤집기게임2_D1 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static int[] stones;
	private static int M;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine()); // 돌의 수
			M = Integer.parseInt(br.readLine()); // 뒤집기 횟수
			
			stones = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int idx = 0; idx < N; idx++) {
				stones[idx] = Integer.parseInt(st.nextToken());
			}
			
			for(int idx = 0; idx < M; idx++) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken()); // i번째 돌을 사이에 두고 
				int j = Integer.parseInt(st.nextToken()); // 마주보는 j개의 돌
			}
			
		} // end of testCase
	} // end of main
} // end of class
