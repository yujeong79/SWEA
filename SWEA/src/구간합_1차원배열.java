import java.util.Arrays;

/**
 * 구간합 조건 : 합을 구할 배열의 원소가 바뀌지 않는 경우
 * 구간합 구하는 시간 : O[N]
 * 구간합을 이용해서 특정 범위 내 합 구하는 시간 : O[1]
 * prefixSum[i] = [0]+[1]+[2]+[3]+...+[i] 원소의 합
 */
public class 구간합_1차원배열 {
	public static void main(String[] args) {
		int[] map = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		for(int i = 0; i < map.length; i++) {
			map[i] = map[i-1] + map[i];
		}
		
		System.out.println(Arrays.toString(map));
		
		//  구간합 : i(포함) ~ j(미포함), 3~8
		System.out.println(map[8-1] - map[3]);
		
		//안녕
		//
	} // end of main
} // end of class
