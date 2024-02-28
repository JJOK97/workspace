package study;

import java.util.Arrays;

public class 분할정복_퀵정렬_호어파티션 {

	static int[] arr = { 5, 22, 32, 26, 57, 19, 32, 55, 84 };

	public static void main(String[] args) {
		
		quickSort(0,arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	// 호어 파티션
	static int partition(int left, int right) {
		int pivot = arr[left]; // 제일 왼쪽의 값을 피봇이라고 하겠다.

		int L = left + 1, R = right; // 시작은 피봇 한칸 옆부터

		while (L <= R) {
			// L : pivot 보다 큰 값을 찾을 때 까지 이동을 하겠다.
			while (L <= R && arr[L] <= pivot)
				L++;

			while (arr[R] > pivot)
				R--;

			if (L < R) {
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
}
