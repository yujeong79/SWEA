import java.io.*;
import java.util.*;

/**
 * 세로위치, 가로위치, 미생물 수, 이동방향
 */

class Bug {
	int r, c, count, direction;

	public Bug(int r, int c, int count, int direction) {
		super();
		this.r = r;
		this.c = c;
		this.count = count;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Bug [r=" + r + ", c=" + c + ", count=" + count + ", direction=" + direction + "]";
	}
	
	
}
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
			
			Bug[] bugArr = new Bug[K];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				bugArr[i] = new Bug(r, c, count, direction);
			}
			
			//System.out.println(Arrays.toString(bugArr));
			
			while(--M >= 0) {
				for(int i = 0; i < K; i++) {
					switch(bugArr[i].direction) {
					case(1):
						bugArr[i].r -= 1;
						if(bugArr[i].r == 0) {
							bugArr[i].count = bugArr[i].count/2;
							bugArr[i].direction = 2;
						}
						break;
					case(2):
						bugArr[i].r += 1;
						if(bugArr[i].r == N-1) {
							bugArr[i].count /= 2;
							bugArr[i].direction = 1;
						}
						break;
					case(3):
						bugArr[i].c -= 1;
						if(bugArr[i].r == 0) {
							bugArr[i].count /= 2;
							bugArr[i].direction = 4;
						}
						break;
					case(4):
						bugArr[i].c += 1;
						if(bugArr[i].r == N-1) {
							bugArr[i].count /= 2;
							bugArr[i].direction = 3;
						}
						break;
					}
				} // 이동 완료
				
//				System.out.println(M + "시간");
//				for(Bug b : bugArr) System.out.println(b);
				
				// 좌표가 같으면 합치기
				for(int i = 0; i < K-1; i++) {
					for(int j = i+1; j < K; j++) {
						if(bugArr[i].r == bugArr[j].r && bugArr[i].c == bugArr[j].c) {
							//System.out.println(bugArr[i].count + ",  " + bugArr[j].count);
							if(bugArr[i].count < bugArr[j].count) {
								bugArr[j].count += bugArr[i].count;
								bugArr[i].count = 0;
							} else {
								bugArr[j].count += bugArr[i].count;	
								bugArr[j].direction = bugArr[i].direction;
								bugArr[i].count = 0;
							}
						}
					}
				}
				
			}
			
			int answer = 0;
			for(Bug b : bugArr) {
				answer += b.count;
			}
			
			sb.append("#" + testCase + " " + answer + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class
