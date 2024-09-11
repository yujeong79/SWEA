import java.io.*;
import java.util.*;

public class Solution_SWEA_1953_탈주범검거_155ms {
	static class Point {
		int r, c, t;

		public Point(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static final int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static final int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
	
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] isVisited;
	static List<Integer>[] dirList;
	
	static int count;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 행
			M = Integer.parseInt(st.nextToken()); // 열
			R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑의 위치 
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간
			
			map = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dirList = new ArrayList[8];
			int idx = 0;
			while(++idx <= 7) {
				switch(idx) {
					case(1):
						dirList[1] = new ArrayList<>(Arrays.asList(0, 1, 2, 3)); 
						break;
					case(2):
						dirList[2] = new ArrayList<>(Arrays.asList(0, 1)); 
						break;
		 			case(3):
		 				dirList[3] = new ArrayList<>(Arrays.asList(2, 3)); 
						break;
					case(4):
						dirList[4] = new ArrayList<>(Arrays.asList(0, 3)); 
						break;
					case(5):
						dirList[5] = new ArrayList<>(Arrays.asList(1, 3)); 
						break;
					case(6):
						dirList[6] = new ArrayList<>(Arrays.asList(1, 2)); 
						break;
					case(7):
						dirList[7] = new ArrayList<>(Arrays.asList(0, 2)); 
						break;
				}
			}
			
			count = 0;
			isVisited = new boolean[N][M];
			BFS(R, C);
			
			sb.append("#" + testCase + " " + count + "\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void BFS(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(i, j, 1));
		isVisited[i][j] = true;
		count++;
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			List<Integer> direction = dirList[map[curr.r][curr.c]];
			
			for(int d : direction) {
				int r = curr.r + dr[d];
				int c = curr.c + dc[d];
				if(r >= 0 && r < N && c >= 0 && c < M && map[r][c] != 0 && !isVisited[r][c]) {
					if(d == 0 && dirList[map[r][c]].contains(1) || d == 1 && dirList[map[r][c]].contains(0) || d == 2 && dirList[map[r][c]].contains(3) || d == 3 && dirList[map[r][c]].contains(2)) {
						queue.add(new Point(r, c, curr.t+1));
						if(curr.t+1 > L) return;
						isVisited[r][c] = true;
						count++;
					}
				}
			}
		}
		
	}
	
} // end of class
