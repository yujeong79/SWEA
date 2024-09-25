import java.io.*;
import java.util.*;

/**
 * 전차는 다음 칸이 평지이면 이동할 수 있음
 * 포탄을 발사하면 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하기 전까지 계속 직진
 * 	벽돌로 만들어진 벽과 부딪히면 벽 파괴
 * 	강철로 만들어진 벽과 부딪히면 아무 일도 일어나지 않음
 * 
 */

public class Solution_SWEA_1873_상호의배틀필드_TEST {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	static int H, W, N;
	static char[][] map;
	static Queue<Character> command;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken()); // (2 ≤ H, W ≤ 20)
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W]; // 게임 맵
			
			for(int i = 0; i < H; i++) { // 게임 맵 입력 받기
				map[i] = br.readLine().toCharArray();
			}
			
			N = Integer.parseInt(br.readLine()); // 사용자가 넣을 입력의 개수, (0 < N ≤ 100)
			command = new LinkedList<>(); // 사용자의 입력을 큐에 저장해서 하나씩 poll 해보자
			
			for(int i = 0; i < N; i++) {
				
			}
			
		} // end of testCase
	} // end of main
} // end of class
