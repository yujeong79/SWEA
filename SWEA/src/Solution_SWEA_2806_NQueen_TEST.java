import java.io.*;
import java.util.*;

public class Solution_SWEA_2806_NQueen_TEST {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N, answer;
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			
			board = new boolean[N][N];
			
			answer = 0;
			backTracking(0, 0, 0);
		
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void backTracking(int r, int c, int queen) {
		if(queen >= N) {
			answer++;
			return;
		}
		
		for(int i = r; i < N; i++) {
			if(isPossible(i, c)) {
				board[i][c] = true;
				backTracking(r+1, )
			}
		}
	}

	private static boolean isPossible(int r, int c) {
		for(int i = 0; i < N; i++) { // 행과 열 검사
			if(board[i][c])
				return false;
			if(board[r][i])
				return false;
		}
		
		int R = r;
		int C = c;
		while(R >= 0 && C >= 0) { // 좌상 검사
			if(board[R][C]) return false;
			R--;
			C--;
		}
		
		R = r;
		C = c;
		while(R < N && C >= 0) { // 좌하 검사
			if(board[R][C]) return false;
			R++;
			C--;
		}
		
		R = r;
		C = c;
		while(R >= 0 && C < N) { // 우상 검사
			if(board[R][C]) return false;
			R--;
			C++;
		}
		
		R = r;
		C = c;
		while(R < N && C < N) { // 우상 검사
			if(board[R][C]) return false;
			R++;
			C++;
		}
		
		return true;
	}
	
} // end of class
