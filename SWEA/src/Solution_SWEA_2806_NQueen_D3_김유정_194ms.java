import java.io.*;
import java.util.*;

public class Solution_SWEA_2806_NQueen_D3_김유정_194ms {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static int[][] board;
	private static int count;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			count = 0;
			
			nQueen(0);
			
			sb.append("#" + testCase + " " + count + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void nQueen(int depth) {
		if(depth == N) {
			count++;
			return;
		}
		
		for(int column = 0; column < N; column++) {
			if(isPromising(depth, column)) {
				board[depth][column] = 1;
				nQueen(depth+1);
				board[depth][column] = 0;
			}
		}
	}

	private static boolean isPromising(int depth, int column) {
		// 같은 열 탐색
		for(int r = 0; r < N; r++) {
			if(board[r][column] == 1) {
				return false;
			}
		}
		
		
		// 좌상 대각선 탐색
		int i = depth;
		int j = column;
		while(i >= 0 && j >= 0) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j--;
		}
		
		// 우상 대각선 탐색
		i = depth;
		j = column;
		while(i >= 0 && j < N) {
			if(board[i][j] == 1) {
				return false;
			}
			i--;
			j++;
		}
		
		return true;
	}
	
} // end of class
