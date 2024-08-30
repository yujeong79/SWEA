import java.io.*;
import java.util.*;

/**
 * 초기 게임 맵의 상태와 사용자의 입력이 순서대로 주어질 때, 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구해보자
 *  U / D / L / R : 전차의 방향을 바꾸고 평지라면 한 칸 이동
 * 	S : 포탄 발사, 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진
 * 		포탄이 벽돌로 만들어진 벽에 부딪히면 벽은 파괴되고 칸은 평지가 됨
 * 		포탄이 강철로 만들어진 벽에 부딪히면 아무 일도 일어나지 않음
 */
 
public class Solution_SWEA_1873_상호의배틀필드_D3_김유정_126ms {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	// 상 하 좌 우
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static int H; // 게임 맵의 높이
	private static int W; // 게임 맵의 너비
	
	private static int r = 0; // 전차의 위치
	private static int c = 0;
	private static int d; // 전차의 방향
	
	private static char[][] map;
	private static int N; // 사용자가 넣을 입력의 개수
	private static char[] command;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			for(int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					switch(map[i][j]) {
					case('^'): d = 0; r = i; c= j; break;
					case('v'): d = 1; r = i; c= j; break; 
					case('<'): d = 2; r = i; c= j; break;
					case('>'): d = 3; r = i; c= j; break;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			command = br.readLine().toCharArray();
			
			Play();
			
			sb.append("#").append(testCase).append(" ");
			for(char[] m : map) {
				for(char c : m) sb.append(c);
				sb.append("\n");
			}
		} // end of testCase
		System.out.println(sb);
	} // end of main

	private static void Play() {
		for(int ci = 0; ci < N; ci++) { // 명령을 다 수행하면 종료
			switch(command[ci]) {
			case('S'): 
				int sr = r; int sc = c; // 포탄의 위치
				while(sr + dr[d] >= 0 && sr + dr[d] < H && sc + dc[d] >= 0 && sc + dc[d] < W) { // 밖을 벗어날 때까지 계속 직진
					sr += dr[d]; sc += dc[d];
					if(map[sr][sc] == '*') { // 벽돌로 만들어진 벽을 만나면
						map[sr][sc] = '.'; // 벽이 파괴되어 평지가 됨
						break;
					} else if(map[sr][sc] == '#') break; // 강철로 만들어진 벽을 만나면 멈춤
				} break;
			case('U'):
				d = 0;
				if(r + dr[d] >= 0 && r + dr[d] < H && c + dc[d] >= 0 && c + dc[d] < W) { // 범위를 벗어나지 않을 때
					if(map[r+dr[d]][c+dc[d]] == '.') {
						map[r][c] = '.'; // 원래 있던 위치는 평지로 바꾸고
						r += dr[d]; c += dc[d]; // 전차를 이동시킴
					}
				} 
				map[r][c] = '^';
				break;
			case('D'):
				d = 1;
				if(r + dr[d] >= 0 && r + dr[d] < H && c + dc[d] >= 0 && c + dc[d] < W) { // 범위를 벗어나지 않을 때
					if(map[r+dr[d]][c+dc[d]] == '.') {
						map[r][c] = '.'; // 원래 있던 위치는 평지로 바꾸고
						r += dr[d]; c += dc[d]; // 전차를 이동시킴
					}
				} 
				map[r][c] = 'v';
				break;
			case('L'):
				d = 2;
				if(r + dr[d] >= 0 && r + dr[d] < H && c + dc[d] >= 0 && c + dc[d] < W) { // 범위를 벗어나지 않을 때
					if(map[r+dr[d]][c+dc[d]] == '.') {
						map[r][c] = '.'; // 원래 있던 위치는 평지로 바꾸고
						r += dr[d]; c += dc[d]; // 전차를 이동시킴
					}
				}
				map[r][c] = '<';
				break;
			case('R'):
				d = 3;
				if(r + dr[d] >= 0 && r + dr[d] < H && c + dc[d] >= 0 && c + dc[d] < W) { // 범위를 벗어나지 않을 때
					if(map[r+dr[d]][c+dc[d]] == '.') {
						map[r][c] = '.'; // 원래 있던 위치는 평지로 바꾸고
						r += dr[d]; c += dc[d]; // 전차를 이동시킴
					}
				} 
				map[r][c] = '>'; 
				break;
			}
		}
	}
	
} // end of class
