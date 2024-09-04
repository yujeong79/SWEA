import java.io.*;
import java.util.*;

public class Solution_SWEA_TEST {
	private static int N;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		N = 4;

		isSelected = new boolean [N];
		
		powerset(0);
		
	} // end of main

	private static void powerset(int idx) {
		if(idx == N) {
			List<Integer> list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) 
					list.add(i+1);
			}
			System.out.println(list.toString());
			return;
		}
		
		isSelected[idx] = true; 
		powerset(idx+1);
		
		isSelected[idx] = false;
		powerset(idx+1);
	}
	
	
} // end of class
