import java.io.*;
import java.util.*;

public class Solution_SWEA_2817_부분수열의합_D3 {
	static int N;
	static int K;
	
	static int answer;
	
	static int[] nums;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // N개의 자연수
			K = Integer.parseInt(st.nextToken()); // 합이 K가 되는 경우의 수
			
			st = new StringTokenizer(br.readLine(), " ");
			nums = new int[N];
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int R = 1; R <= N; R++) {
				result = new int[R];
				comb(0, 0, R);
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	static void comb(int cnt, int start, int R) {
		if(cnt == R) {
			int sum = 0;
			for(int n : result) sum += n;
			if(sum == K) answer++;
			return;
		}
		
		for(int i = start; i < N; i++) {
			result[cnt] = nums[i];
			comb(cnt+1, i+1, R);
		}
	}

} // end of class
