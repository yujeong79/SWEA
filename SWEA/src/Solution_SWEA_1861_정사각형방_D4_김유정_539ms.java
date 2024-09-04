import java.io.*;
import java.util.*;

public class Solution_SWEA_1861_정사각형방_D4_김유정_539ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int N;
	private static int[][] rooms;
	private static int[] startRoom;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N+2][N+2];
			startRoom = new int[N*N+1];
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					BFS(i,j);
					max = Math.max(max, startRoom[rooms[i][j]]);
				}
			}
			
			sb.append("#" + testCase + " ");
			for(int i = 1; i <= N*N; i++) {
				if(startRoom[i] == max) {
					sb.append(i + " " + max + "\n");
					break;
				}
			}
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	private static void BFS(int i, int j) {
		int[] start = {i, j};
		Queue<int[]> queue = new LinkedList<>();
		startRoom[rooms[i][j]]++;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			
			if(rooms[r+dr[0]][c+dc[0]] != 0 || rooms[r+dr[1]][c+dc[1]] != 0 || rooms[r+dr[2]][c+dc[2]] != 0 || rooms[r+dr[3]][c+dc[3]] != 0) {
				for(int d = 0; d < 4; d++) {
					if(rooms[r+dr[d]][c+dc[d]] != 0 && rooms[r+dr[d]][c+dc[d]] - rooms[r][c] == 1) {
						startRoom[rooms[i][j]]++;
						int[] next = {r+dr[d], c+dc[d]};
						queue.add(next);
						break;
					}
				}
			}
				
		}
	}
	
} // end of class
