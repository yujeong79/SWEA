import java.io.*;
import java.util.*;

public class Solution_SWEA_1767_프로세서연결하기_김유정_565ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] dr = {-1, 1, 0, 0};
	static final int[] dc = {0, 0, -1, 1};
	
	static int N;
	static char[][] processor;
	
	static int maxCore;
	static int total;
	
	static int count = 0;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine().trim());
			
			processor = new char[N][N];
			for(int i = 0; i < N; i++) {
				String line = br.readLine(); 
				for(int j = 0, c = 0; j < N; j++, c+=2) {
					processor[i][j] = line.charAt(c);
					if(processor[i][j] == 1) total++;
				}
			}
			
			maxCore = Integer.MIN_VALUE;
			answer = Integer.MAX_VALUE;
			backTracking(1, 1, 0, 0);
			
			sb.append("#" + testCase + " " + answer + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void backTracking(int r, int c, int num, int length) {
		if(c > N-2) { // 해당 행 탐색 중 열을 벗어나면 다음 행 탐색 시작
			backTracking(r+1, 0, num, length);
			return;
		}
		
		if(r > N-2) { // 모든 행을 다 탐색하면 종료
			if(maxCore < num) {
				maxCore = num;
				answer = length;
			} else if(maxCore == num) {
				answer = Math.min(answer, length);
			}
			return;
		}
		
		if(processor[r][c] == '1') { // 해당 셀에 코어가 있는 경우
			for(int d = 0; d < 4; d++) { // 해당 방향으로 전선을 놓을 수 있는지 체크
				if(isPromising(r, c, d)) {
					backTracking(r, c+1, num+1, length+count);
					// 되돌리기
					reset(r, c, d);
				}
			}
			// 해당 방향으로 전선을 놓을 수가 업거나 다 놓아봤다면
		}
		
		// 해당 셀에 연결할 수 있는 코어가 없는 경우
		backTracking(r, c+1, num, length);
	}

	private static void reset(int row, int column, int d) {
		int r = row + dr[d];
		int c = column + dc[d];
		while(r >= 0 && r <= N-1 && c >= 0 && c <= N-1) {
			processor[r][c] = '0';
			r += dr[d];
			c += dc[d];
		}
	}

	private static boolean isPromising(int row, int column, int d) {
		int r = row + dr[d];
		int c = column + dc[d];	
		
		while(r >= 0 && r <= N-1 && c >= 0 && c <= N-1) {
			if(processor[r][c] == '1' || processor[r][c] == '-') return false;
			r += dr[d];
			c += dc[d];
		}
		
		// 해당 방향으로 전선을 놓을 수 있다면 전선 연결
		count = 0;
		r = row + dr[d];
		c = column + dc[d];
		while(r >= 0 && r <= N-1 && c >= 0 && c <= N-1) {
			processor[r][c] = '-'; count++;
			r += dr[d];
			c += dc[d];
		}

		return true;
	}
	
} // end of class
