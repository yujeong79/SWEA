import java.io.*;
import java.util.*;

class Group {
	int r, c, cnt, d;

	public Group(int r, int c, int cnt, int d) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.d = d;
	}

	@Override
	public String toString() {
		return "Group [r=" + r + ", c=" + c + ", cnt=" + cnt + ", d=" + d + "]";
	}
}

public class Solution_SWEA_2382_미생물격리_모의역량_TEST {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int testCase = 0;
		while(++testCase <= T) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 한 변의 셀의 개수
			int M = Integer.parseInt(st.nextToken()); // 격리 시간
			int K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수
			
			List<Group> list = new ArrayList<>();
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int row = Integer.parseInt(st.nextToken());
				int column = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				list.add(new Group(row, column, count, direction));
			}
			
			int m = 0;
			while(++m <= M) { // 격리시간동안 움직이기
				for(Group g : list) {
					switch(g.d) {
					case(1): // 상
						g.r -= 1;
						if(g.r <= 0 || g.r >= N-1 || g.c <= 0 || g.c >= N-1) {
							g.cnt /= 2;
							g.d = 2;
						} break;
					case(2): // 하
						g.r += 1;
						if(g.r <= 0 || g.r >= N-1 || g.c <= 0 || g.c >= N-1) {
							g.cnt /= 2;
							g.d = 1;
						} break;
					case(3): // 좌
						g.c -= 1;
						if(g.r <= 0 || g.r >= N-1 || g.c <= 0 || g.c >= N-1) {
							g.cnt /= 2;
							g.d = 4;
						} break;
					case(4): // 우
						g.c += 1;
						if(g.r <= 0 || g.r >= N-1 || g.c <= 0 || g.c >= N-1) {
							g.cnt /= 2;
							g.d = 3;
						} break;
					}
				} // 미생물 군집 이동완료
				
				// 동일한 셀에 모인 군집 합치기 
				Map<String, Set<Group>> map = new HashMap<>(); // 같은 좌표의 미생물 군집을 map에 저장해놓고
				for(int i = 0; i < list.size()-1; i++) {
					for(int j = i+1; j < list.size(); j++) {
						if(list.get(i).r == list.get(j).r && list.get(i).c == list.get(j).c) { // 좌표가 같으면
							String location = list.get(i).r + " " + list.get(i).c;
							if(map.get(location) == null) {
								Set<Group> set = new HashSet<>();
								map.put(location, set);
							} 
							map.get(location).add(list.get(i)); // 해당 좌표의 set에 넣기
							map.get(location).add(list.get(j));
						}
					}
				}
				
				for(String key : map.keySet()) {
					st = new StringTokenizer(key, " ");
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					Group newG = new Group(r, c, 0, 0); // 해당 좌표의 새로운 군집을 만들어서
					
					int maxCnt = 0;
					for(Group g : map.get(key)) {
						if(maxCnt < g.cnt) { // 가장 큰 군집의 방향을 저장해두기
							maxCnt = g.cnt;
							newG.cnt += g.cnt;
							newG.d = g.d;
						} else { // 가장 큰 군집이 아니면 크기만 누적하기
							newG.cnt += g.cnt;
						}
					}
					
					list.add(newG); // 새로운 군집 넣기
					for(Group g : map.get(key)) {
						g.cnt = 0;
					}
				}
				
				// 미생물 수가 0인 군집 없애기
				for(int i = list.size()-1; i >= 0; i--) {
					if(list.get(i).cnt == 0) {
						list.remove(i);
					}
				}
			} // 한 시간 종료
			
			int total = 0;
			for(Group g : list) {
				total += g.cnt;
			}
			
			sb.append("#" + testCase + " " + total + "\n");
		} // end of testCase
		System.out.println(sb);
	} // end of main
} // end of class
