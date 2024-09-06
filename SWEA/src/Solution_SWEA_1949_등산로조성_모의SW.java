import java.io.*;
import java.util.*;

public class Solution_SWEA_1949_등산로조성_모의SW {
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int N;
	private static int K;
	private static int[][] map;
	private static int[][] tmp;
	private static boolean[][] isVisited;
	private static int length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			int answer = 0; // 각 테스트케이스의 답
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지도 한 변의 길이, N*N
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			int max = 0; // 봉우리
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			tmp = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == max) {
						for(int ii = 0; ii < N; ii++) {
							for(int jj = 0; jj < N; jj++) {
								tmp[ii][jj] = map[ii][jj];
							}
						}
						length = 1;
						//flag = false;
						isVisited = new boolean[N][N];
						BFS(i, j); // 모든 등산로는 봉우리에서 시작
						answer = Math.max(length, answer);
					}
				}
			}
			sb.append("#" + testCase + " " + answer + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		

		int[] point = {i, j, 1, 0};
		queue.add(point);
		isVisited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			int l = curr[2];
			int construction = curr[3]; // 0이면 공사를 아직 하지 않음, 1이면 공사를 했음
			length = l;
			isVisited[r][c] = true;
			
			System.out.println(r +", " +c);
			for(int[] a : tmp) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println("length : " + length);
			System.out.println();
			
			for(int d = 0; d < 4; d++) { // 상 하 좌 우 탐색
				if(r+dr[d] >= 0 && r+dr[d] < N && c+dc[d] >= 0 && c+dc[d] < N && !isVisited[r+dr[d]][c+dc[d]]) { // 범위 안에 있는지
					if(tmp[r+dr[d]][c+dc[d]] < tmp[r][c]) { // 현재 위치보다 작으면
						point = new int[] {(r+dr[d]), (c+dc[d]), l+1, construction};
						queue.add(point);
					} else {
						for(int k = 1; construction == 0 && k <= K; k++) {
							if(tmp[r+dr[d]][c+dc[d]] - k < tmp[r][c]) {
								tmp[r+dr[d]][c+dc[d]] -= k;
								point = new int[] {(r+dr[d]), (c+dc[d]), l+1, construction*-1};
								queue.add(point);
							}
						}
					}
				}
			}
			
		}
	}
	
} // end of class
