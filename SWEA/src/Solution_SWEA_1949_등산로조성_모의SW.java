import java.io.*;
import java.util.*;

public class Solution_SWEA_1949_등산로조성_모의SW {
	static class Point {
		int r, c, l, v;
		boolean construction;

		public Point(int r, int c, int l, boolean construction, int v) {
			this.r = r;
			this.c = c;
			this.l = l;
			this.v = v;
			this.construction = construction;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ")의 length : " + l + ", 봉우리 높이 : " + v;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int N, K;
	static int[][] map;
	
	static int maxLength;
	
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
		
		boolean[][] isVisited = new boolean[N][N];
		stack.add(new Point(i, j, 1, false, map[i][j]));
		
		while(!stack.isEmpty()) {
			Point curr = stack.pop();
			maxLength = Math.max(curr.l, maxLength);
			isVisited[curr.r][curr.c] = true;
			
			for(int d = 0; d < 4; d++) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < N && !isVisited[r][c]) {
					if(curr.v > map[r][c]) {
						stack.add(new Point(r, c, curr.l+1, curr.construction, map[r][c]));
					} else if(!curr.construction && curr.v > map[r][c]-K) {
						stack.add(new Point(r, c, curr.l+1, true, curr.v-1));
					}
				}
			}
			
			isVisited[curr.r][curr.c] = false;
		}
	}
	
} // end of class
