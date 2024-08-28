import java.io.*;
import java.util.*;

public class Solution_SWEA_14229_백만개의정수정렬_D2_김유정_543ms {
	static int[] arr = new int[1000000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int i = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}
		
		// 퀵 정렬
		quickSort(0, arr.length-1);
		
		System.out.println(arr[500000]);
	} // end of main
	
	static void quickSort(int left, int right) {
		if(left >= right) return;
		
		int pivot = partition(left, right);
		quickSort(left, pivot-1);
		quickSort(pivot+1, right);			
	}

	static int partition(int left, int right) {
		int pivot = arr[left]; // 구간의 맨 첫 요소를 pivot으로 지정
		
		int L = left+1; // 구간의 첫 탐색 요소를 피벗의 다음 요소로 지정
		int R = right;
		
		while(L <= R) { // 탐색하는 중
			while(L <= R && arr[L] <= pivot) L++; // 피벗값보다 같은 것이 왼쪽에 있어도 됨
			while(arr[R] > pivot) R--;
			
			if(L < R) { // 같으면 안바꿔도 되니까
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
	
} // end of class
