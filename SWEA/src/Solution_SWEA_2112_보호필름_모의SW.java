import java.io.*;
import java.util.*;

public class Solution_SWEA_2112_보호필름_모의SW {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int D, W, K;
	static char[][] film;
	static char[] injected;
	static boolean testResult;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken()); // 보호 필름의 두께
			W = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 합격 기준
			
			film = new char[D][W];
			for(int i = 0; i < D; i++) {
				String str = br.readLine();
				for(int j = 0, ci = 0; j < W; j++, ci+=2) {
					film[i][j] = str.charAt(ci);
				}
			}
			
			injected = new char[D];
			Arrays.fill(injected, 'X');
			
			testResult = false;
			
			int c = 0;
			for(; !testResult && c <= D; c++) {
				injection(c); // 0회 ~ D회만큼 약물 투입
				
			}
			
			if(testResult) {
				sb.append("#" + testCase + " " + c + "\n");
				break;
			}
			
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void injection(int count) {
		if(testResult) {
			return;
		}
		
		if(count <= 0) {
			performanceTest();
			return;
		}
		
		for(int i = 0; !testResult && i < D; i++) { // 모든 행을 순회하며
			if(injected[i] == 'X') { // 약물을 주입하지 않았다면
				injected[i] = '0'; // 약품 A 넣어보기
				injection(count-1);
				
				injected[i] = '1'; // 약품 B 넣어보기
				injection(count-1);
				
				injected[i] = 'X'; // 원상복구
			}
		}
		
	}

	private static void performanceTest() {
		for(int c = 0; c < W; c++) {
			int continuous = 1;
			
			for(int r = 1; r < D; r++) {
				char previous = film[r-1][c];
				char curr = film[r][c];
				if(injected[r-1] == '0' || injected[r-1] == '1') previous = injected[r-1];
				if(injected[r] == '0' || injected[r] == '1') curr = injected[r];
				
				if(previous == curr) continuous++;
				else continuous = 1;
				
				if(continuous >= K) break; // 합격기준 K에 부합하면
				
			}
			
			if(continuous < K) return; // 한 구역이 합격을 하지 못하면 종료
		}
		
		testResult = true;
		
	}
	
} // end of class
