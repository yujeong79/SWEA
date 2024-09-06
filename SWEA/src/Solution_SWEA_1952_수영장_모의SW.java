import java.io.*;
import java.util.*;

/**
 * 각 이용권의 요금과 각 달의 이용 계획이 입력
 * 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 그 비용을 정답으로 출력
 */
public class Solution_SWEA_1952_수영장_모의SW {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] tickets = new int[4];
			for(int i = 0; i < 4; i++) {
				tickets[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] plan = new int[12];
			for(int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			
		} // end of testCase
	} // end of main
} // end of class
