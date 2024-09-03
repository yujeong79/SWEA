import java.io.*;
import java.util.*;

public class Solution_SWEA_7733_치즈도둑_D4_김유정 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int[][] cheese;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			N = Integer.parseInt(br.readLine());
			
			cheese = new int[N][N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int num = 0;
			while(++num <= 100) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(cheese[i][j] == num) cheese[i][j] = 0;
					}
				}
				
				
			}
			
		} // end of testCase
	} // end of main
} // end of class
