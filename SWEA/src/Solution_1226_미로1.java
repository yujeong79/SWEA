import java.io.*;
import java.util.*;

public class Solution_1226_미로1 {
	// 초기화 함수 ///////////////////////
	static void init() {
		map = new char[16][16];
		start = new int[2];
		answer = 0;
	}
	///////////////////////////////////
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static char[][] map;
	static int[] start;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		int testCase = 0;
		while(++testCase <= 10) {
			// 입력 /////////////////////////////////////////////////////
			int T = Integer.parseInt(br.readLine());
			
			init();
			
			for(int i = 0; i < 16; i++) {
				String str = br.readLine();
				for(int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == '2') {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			/////////////////////////////////////////////////////////
			
			BFS(start[0], start[1]);
			
			sb.append("#" + T + " " + answer + "\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	private static void BFS(int startR, int startC) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {startR, startC});
		map[startR][startC] = '1'; // isVisited 배열을 굳이 하나 더 만들지 말고, 방문한 길은 '1'로 바꿔주자
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dir[d][0];
				int nc = curr[1] + dir[d][1];
				
				if(nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && map[nr][nc] != '1') {
					queue.offer(new int[] {nr, nc});
					
					if(map[nr][nc] == '3') {
						answer = 1;
						return;
					}
					
					map[nr][nc] = '1';
				}
			}
		}
		
	}
	
} // end of class
