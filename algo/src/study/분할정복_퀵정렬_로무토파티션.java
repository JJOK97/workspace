package study;

import java.util.Arrays;

public class 분할정복_퀵정렬_로무토파티션 {

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

	// 로무토 파티션
	static int partition(int left, int right) {
		int pivot = arr[right];
		int i = left-1;
		
		for(int j = left; j < right; j++) {
			if(arr[j] <= pivot) {
				i++;
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		
		// pivot을 자기 위치로 보내야해
		int tmp = arr[i+1];
		arr[i+1] = arr[right];
		arr[right] =  tmp;
		
		return i + 1;
	}
}
