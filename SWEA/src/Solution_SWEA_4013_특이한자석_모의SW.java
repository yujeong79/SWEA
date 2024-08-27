import java.io.*;
import java.util.*;

/**
 * N극 0, S극 1
 * magnet[0][2] <-> magnet[1][6]
 * magnet[1][2] <-> magnet[2][6]
 * magnet[2][2] <-> magnet[3][6]
 * 
 * 다르면 한 칸씩 미룸
 */


public class Solution_SWEA_4013_특이한자석_모의SW {
	
	static int[][] magnet;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			
			int K = Integer.parseInt(br.readLine()); // 자석을 회전시키는 횟수
			
			magnet = new int[5][8];
			for(int i = 1; i <= 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 하나의 바퀴가 돌면 다른 바퀴도 봐야하는데..
			for(int i = 0; i < K; i++) { // 회전 정보 받기
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int wheel = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				
				//System.out.println("바퀴 : " + wheel + ", 방향 : " + direction);
				
				boolean[] flag = new boolean[5];
				flag[wheel] = true; // 해당 바퀴를 돌려야하면 true 저장
				
				if(wheel == 1) {
					
					if(magnet[1][2] != magnet[2][6]) {
						flag[2] = true;
						if(magnet[2][2] != magnet[3][6]) {
							flag[3] = true;
							if(magnet[3][2] != magnet[4][6]) {
								flag[4] = true;
							}
						}
					} 
					//System.out.println("기존 자석 : " + Arrays.deepToString(magnet)); 
					rotation(1, direction, flag[1]); // 바퀴1 회전하기
					rotation(2, direction*-1, flag[2]); // 바퀴2 회전하기
					rotation(3, direction, flag[3]); // 바퀴3 회전하기
					rotation(4, direction*-1, flag[4]); // 바퀴4 회전하기
					
				} else if(wheel == 2) {
					
					if(magnet[1][2] != magnet[2][6]) {
						flag[1] = true;
					}
					if(magnet[2][2] != magnet[3][6]) {
						flag[3] = true;
						if(magnet[3][2] != magnet[4][6]) {
							flag[4] = true;
						}
					}
					//System.out.println("기존 자석 : " + Arrays.deepToString(magnet));
					rotation(1, direction*-1, flag[1]); // 바퀴1 회전하기
					rotation(2, direction, flag[2]); // 바퀴2 회전하기
					rotation(3, direction*-1, flag[3]); // 바퀴3 회전하기
					rotation(4, direction, flag[4]); // 바퀴4 회전하기
				
				} else if(wheel == 3) {
					
					if(magnet[2][2] != magnet[3][6]) {
						flag[2] = true;
						if(magnet[1][2] != magnet[2][6]) {
							flag[1] = true;
						}
					}
					
					if(magnet[3][2] != magnet[4][6]) {
						flag[4] = true;
					}
					//System.out.println("기존 자석 : " + Arrays.deepToString(magnet));
					rotation(1, direction, flag[1]); // 바퀴1 회전하기
					rotation(2, direction*-1, flag[2]); // 바퀴2 회전하기
					rotation(3, direction, flag[3]); // 바퀴3 회전하기
					rotation(4, direction*-1, flag[4]); // 바퀴4 회전하기
					
				} else {
					if(magnet[3][2] != magnet[4][6]) {
						flag[3] = true;
						if(magnet[2][2] != magnet[3][6]) {
							flag[2] = true;
							if(magnet[1][2] != magnet[2][6]) {
								flag[1] = true;
							}
						}
					} 
					//System.out.println("기존 자석 : " + Arrays.deepToString(magnet));
					rotation(1, direction*-1, flag[1]); // 바퀴1 회전하기
					rotation(2, direction, flag[2]); // 바퀴2 회전하기
					rotation(3, direction*-1, flag[3]); // 바퀴3 회전하기
					rotation(4, direction, flag[4]); // 바퀴4 회전하기
				}
			}
			
			//System.out.println(Arrays.deepToString(magnet));
			int answer = magnet[1][0]*1 + magnet[2][0]*2 + magnet[3][0]*4 + magnet[4][0]*8;
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
			
		} // end of testCase
		System.out.println(sb);
	} // end of main
	
	static void rotation(int wheel, int direction, boolean flag) {
		if(flag) {
			List<Integer> temp = new ArrayList<>();
			
			if(direction != 1) { // 반시계 방향이면 오른쪽으로 한 칸씩 이동
				for(int i = 1; i < 8; i++) {
					temp.add(magnet[wheel][i]);
				}
				temp.add(magnet[wheel][0]);
				
				for(int i = 0; i < 8; i++) {
					magnet[wheel][i] = temp.get(i);
				}
				//System.out.println(wheel + "바퀴, 반시계 방향 회전 : " + Arrays.deepToString(magnet));
				
			} else { // 시계 방향이면 왼쪽으로 한 칸씩 이동
				for(int i = 0; i < 7; i++) {
					temp.add(magnet[wheel][i]);
				}
				
				temp.add(0, magnet[wheel][7]); // 기존의 마지막 자석을 맨 앞에 삽입
				
				for(int i = 0; i < 8; i++) {
					magnet[wheel][i] = temp.get(i);
				}
				//System.out.println(wheel + "바퀴, 시계 방향 회전 : " + Arrays.deepToString(magnet));
			}
		}
	}
	
} // end of class
