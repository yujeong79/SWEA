import java.io.*;
import java.util.*;

/**
 * N * N 보드에 퀸 N개가 서로 공격할 수 없게 놓는 경우의 수
 */

public class Solution_SWEA_2806_NQueen_D3_김유정 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int N;
	
	static boolean[][] board;
	
	static boolean[][] QueenLocation;
	
	static boolean flag;
	
	// 상 하 좌 우 좌상 우상 우하 좌하
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
	
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			answer = 0;
			
			N = Integer.parseInt(br.readLine()); // 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수
			
			board = new boolean[N][N];
			QueenLocation = new boolean[N][N];
			
			placeQueen(N);
			
			sb.append("#" + testCase + " " + answer + "\n");
		} // end of testCase	
		System.out.println(sb);
	} // end of main
	
	static void placeQueen(int cnt) {
		if(cnt == 0) { // N만큼의 Queen을 다 놓았으면
			answer++;
			return;
		}
		
		for(int i = 0; i < N; i++) { // 모든 board 칸을 순회하며
			for(int j = 0; j < N; j++) {
				if(!board[i][j]) { // false, 해당 칸에 Queen이 없거나 공격 범위가 아니라면
					boolean[][] tmp = board; // Queen을 놓기 이전의 board 상태 임시 저장
					flag = true;
					
					QueenLocation[i][j] = true; // 놓아주기
					attackRange(i, j); // 해당 칸의 Queen의 공격 범위를 모두 true;로 바꿔주기
					
					if(flag) { // 해당 자리에 Queen을 두었으면
						System.out.println(i + ", " + j);
						printArr(board);
						placeQueen(cnt-1); 
						board = tmp; // (i, j) 자리에 Queen을 두기 이전의 상태로 다시 되돌아감
					} else { // 해당 자리에 Queen을 두지 못했으면	
						System.out.println("실패 : " + i + ", " + j);
						board = tmp;
						placeQueen(cnt);
					}
				}
			}
		}
	}
	
	static void attackRange(int r, int c) {
		board[r][c] = true;
		
		int d = 0;
		int Qr = r;
		int Qc = c;
		
		while(d <= 7) {
			r = Qr; c = Qc;
			while(r+dr[d] < N && r+dr[d] >= 0 && c+dc[d] < N && c+dc[d] >= 0) {
				r += dr[d];
				c += dc[d];
				
				if(QueenLocation[r][c]) {// 공격 범위에 Queen이 있다면
					flag = false; // 그 자리에 둘 수 없음
					return;
				}
				
				System.out.println(r + ", " + c);
				board[r][c] = true;
			}
			d++;
		}
	}
	
	static void printArr(boolean[][] arr) {
		for(boolean[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
	
} // end of class
