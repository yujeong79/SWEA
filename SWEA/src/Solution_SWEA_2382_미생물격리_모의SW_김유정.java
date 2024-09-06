import java.io.*;
import java.util.*;

/**
 * 세로위치, 가로위치, 미생물 수, 이동방향
 */
public class Solution_SWEA_2382_미생물격리_모의SW_김유정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());  // N*N개의 정사각형
			int M = Integer.parseInt(st.nextToken()); // M시간 후 남아 있는 미생물의 수 총합을 구하기
			int K = Integer.parseInt(st.nextToken()); // K개의 미생물 군집
			
		} // end of testCase
	} // end of main
} // end of class
