import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 각 테스트케이스의 출력값을 모아서 저장했다가 한 번에 출력하기 위한 용도
		
		int T = Integer.parseInt(br.readLine()); // 전체 테스트케이스의 수 입력 받기
		int testCase = 0; // 각 테스트케이스
		while(++testCase <= T) { // 테스트케이스가 전체 테스트케이스의 수 만큼 반복하면 종료
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");  // 어장 한 변의 길이와 그물 한 변의 길이 입력 받기
			int N = Integer.parseInt(st.nextToken()); // 어장 한 변의 길이
			int M = Integer.parseInt(st.nextToken()); // 그물 한 변의 길이
			
			int[][] fish = new int[N][N]; // 각 칸의 어획량을 저장하기 위한 2차원 배열
			
			for(int i = 0; i < N; i++) { // 각 행을 순회하며
				st = new StringTokenizer(br.readLine(), " "); // 각 행을 입력받고
				for(int j = 0; j < N; j++) { // 행의 각 열을 순회하며
					fish[i][j] = Integer.parseInt(st.nextToken()); // 칸마다 어획량을 저장
				}
			}
			
			int r = 0; int c = 0; // 현재 row 위치, column 위치
			int max = 0; // 최대 어획량을 저장하기 위한 변수, 최대 어획량이 0 이하이면 답이 0이기 때문에 초기값으로 0 할당
			
			while(r < N && c < N) { // 2차원 배열을 모두 탐색하면 종료
				int sum = 0; // 현재 위치에서 M*M 만큼의 어획량을 저장하기 위한 변수
				
				for(int i = r; i < r+M; i++) { // 현재 row에서 M 크기만큼 순회
					for(int j = c; j < c+M; j++) { // 현재 column에서 M 크기만큼 순회
						if(i < N && j < N) { // i와 j가 모두 배열의 범위를 벗어나지 않을 때만
							sum += fish[i][j]; // sum에 해당 칸의 어획량을 누적
						}
					}
				}
				
				max = Math.max(max, sum); // 현재 위치에서 M*M 크기의 어획량을 구했으면 max 업데이트
				c = (c+1)%N; // c을 한 칸씩 증가해주는데, 만약 c가 배열의 크기를 벗어나면 그 다음 행의 0부터 다시 순회하도록 % N 한 값을 저장
				if(c == 0) r++; // c가 다시 0이 됐으면 현재 위치를 다음 행으로 이동해야 하니까 column 1 증가
			}
			
			r = 0; c = 0; // 현재 row 위치, column 위치
			
			while(r < N && c < N) { // 2차원 배열을 모두 탐색하면 종료
				int sum = 0; // 현재 위치에서 M*M 만큼의 어획량을 저장하기 위한 변수
				
				for(int i = c; i < c+M; i++) { // 현재 row에서 M 크기만큼 순회
					for(int j = r; j < r+M; j++) { // 현재 column에서 M 크기만큼 순회
						if(i < N && j < N) { // i와 j가 모두 배열의 범위를 벗어나지 않을 때만
							sum += fish[j][i]; // sum에 해당 칸의 어획량을 누적
						}
					}
				}
				
				max = Math.max(max, sum); // 현재 위치에서 M*M 크기의 어획량을 구했으면 max 업데이트
				r = (r+1)%N; // c을 한 칸씩 증가해주는데, 만약 c가 배열의 크기를 벗어나면 그 다음 행의 0부터 다시 순회하도록 % N 한 값을 저장
				if(r == 0) c++; // c가 다시 0이 됐으면 현재 위치를 다음 행으로 이동해야 하니까 column 1 증가
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n"); // 각 테스트케이스의 출력값, 최대 어획량 출력
		} // end of testCase
		System.out.println(sb); // 출력
	} // end of main
} // end of class
