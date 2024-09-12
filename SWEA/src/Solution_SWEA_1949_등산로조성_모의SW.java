import java.io.*;
import java.util.*;

public class Solution_SWEA_1949_등산로조성_모의SW {
	static class Point {
		int r, c, l;

		public Point(int r, int c, int l) {
			this.r = r;
			this.c = c;
			this.l = l;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ")의 length : " + l;
		}
	}
	
	static class Construction {
		int r, c, length;
		boolean state;
		
		public Construction() {
			this.state = false;
		}
		
		public Construction(int r, int c, boolean state, int length) {
			this.r = r;
			this.c = c;
			this.state = state;
			this.length = length;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N, K;
	static int[][] map;
	
	static boolean[][] isVisited;
	static int maxLength;
	
	static Construction check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지도 한 변의 길이, N*N
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			int highestPoint = 0; // 봉우리
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					highestPoint = Math.max(highestPoint, map[i][j]);
				}
			}
			
			maxLength = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == highestPoint) {
						check = new Construction();
						DFS(i, j, 0);
					}
				}
			}

			sb.append("#" + testCase + " " + maxLength + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void DFS(int i, int j, int roadLength) {
		Stack<Point> stack = new Stack<>();
		
		stack.add(new Point(i, j, 1));
		
		int[][] tempMap = new int[N][N];
		for(int r = 0; r < N; r++) {
			tempMap[r] = map[r].clone();
		}
		
		while(!stack.isEmpty()) {
			Point curr = stack.pop();
			maxLength = Math.max(curr.l, maxLength);
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < N) {
					if(tempMap[curr.r][curr.c] > tempMap[r][c]) {
						stack.add(new Point(r, c, curr.l+1));
					} else if(!check.state && tempMap[curr.r][curr.c] > tempMap[r][c]-K) {
						check = new Construction(r, c, true, curr.l+1);
						stack.add(new Point(r, c, curr.l+1));
						tempMap[r][c] = tempMap[curr.r][curr.c]-1;
					}
				}
			}
		}
	}
	
} // end of class
