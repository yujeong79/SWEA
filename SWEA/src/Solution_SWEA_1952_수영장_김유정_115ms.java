import java.io.*;
import java.util.*;

public class Solution_SWEA_1952_수영장_김유정_115ms {	
	private static int[] cost;
	private static int minCost;
	private static int[] month;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			cost = new int[4];
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			month = new int[12];
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			minCost = Integer.MAX_VALUE;
			backTracking(0, 0);

			sb.append("#" + testCase + " " + minCost + "\n");
		} // end of testCase	
		System.out.println(sb);
	} // end of main
	
	private static void backTracking(int m, int sum) {
		if(m >= 12) {
			minCost = Math.min(minCost, sum);
			return;
		}
	
		backTracking(m+1, sum + month[m]*cost[0]); // 1일 이용권 계산
		
		backTracking(m+1, sum + cost[1]); // 1달 이용권 계산
		
		backTracking(m+3, sum + cost[2]); // 3달 이용권 계산
		
		backTracking(m+12, sum + cost[3]);

	}
	
} // end of class
