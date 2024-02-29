package study;

import java.util.Arrays;

public class 순열_2_swap {

	static int[] nums;
	static int N;

	public static void main(String[] args) {
		nums = new int[] { 0, 1, 2 };
		N = nums.length;

	}

	// idx = 현재 판단하는 위치
	public static void perm(int idx) {

		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}

		// 재귀조건
		for (int i = idx; i < N; i++) {

			// (i, idx)의 위치를 swap
			swap(i, idx);
			perm(idx + 1);
			// (i, idx)의 위치를 swap (원상복구하는 과정)
			swap(i, idx);
			
		}
	}

	public static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}
