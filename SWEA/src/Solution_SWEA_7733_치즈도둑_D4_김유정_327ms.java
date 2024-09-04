import java.io.*;
import java.util.*;

public class Solution_SWEA_7733_치즈도둑_D4_김유정_327ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int N;
	private static int[][] cheese;
	private static int mass;
	private static int answer;
	
	private static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			answer = 1;
			
			cheese = new int[N+2][N+2];
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int num = 0;
			while(++num <= 100) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(cheese[i][j] == num) cheese[i][j] = 0;
					}
				}
				
				mass = 0;
				isVisited = new boolean[N+2][N+2];
				for(int r = 1; r <= N; r++) {
					for(int c = 1; c <= N; c++) {
						if(!isVisited[r][c] && cheese[r][c] != 0) { DFS(r, c); mass++; }
					}
				}
				
				answer = Math.max(mass, answer);
			}
			
			sb.append("#" + testCase + " " + answer + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void DFS(int r, int c) {
		isVisited[r][c] = true;
		if(cheese[r+dr[0]][c+dc[0]] == 0 && cheese[r+dr[1]][c+dc[1]] == 0 && cheese[r+dr[2]][c+dc[2]] == 0 && cheese[r+dr[3]][c+dc[3]] == 0)
			return;
		
		if(cheese[r+dr[0]][c+dc[0]] != 0 || cheese[r+dr[1]][c+dc[1]] != 0 || cheese[r+dr[2]][c+dc[2]] != 0 || cheese[r+dr[3]][c+dc[3]] != 0) {
			for(int i = 0; i < 4; i++) {
				if(cheese[r+dr[i]][c+dc[i]] != 0 && !isVisited[r+dr[i]][c+dc[i]])
					DFS(r+dr[i], c+dc[i]);
			}
		}
	}
} // end of class
