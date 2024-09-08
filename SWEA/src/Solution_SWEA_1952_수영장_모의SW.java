import java.io.*;
import java.util.*;

public class Solution_SWEA_1952_수영장_모의SW {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] cost = new int[4];
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] month = new int[12];
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			int min = Integer.MAX_VALUE;
			
			

			sb.append("#" + testCase + " " + min + "\n");
		} // end of testCase	
		System.out.println(sb);
	} // end of main
} // end of class
