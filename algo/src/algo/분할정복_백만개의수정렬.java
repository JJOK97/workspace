package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 분할정복_백만개의수정렬 {

	static int[] arr;
	static int[] sortedArr;

	public static void main(String[] args) throws Exception {

		arr = new int[1000000];
		sortedArr = new int[arr.length];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr.length; i++) {

			arr[i] = Integer.parseInt(st.nextToken());

		}

		mergeSort(0, arr.length - 1);
		System.out.println(arr[500000]);

	}

	static void mergeSort(int left, int right) {

		// if(left >= right) return; 이렇게 컷 하거나
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간의 시작 포인트
		int R = mid + 1; // 오른쪽 구간의 시작 포인트
		int idx = left; // 정렬된 원소 저장할 위치

		// 서로 아직 비교 할 수 잇는 값들이 남아있을때
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R])
				sortedArr[idx++] = arr[L++];
			else
				sortedArr[idx++] = arr[R++];
		}
		// 왼쪽구간 남았어
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}
		// 오른쪽구간 남았어
		else {
		    for (int i = R; i <= right; i++) {
		        sortedArr[idx++] = arr[i];
		    }
		}

		// 마지막으로 해야할 행위 ~~~
		// 원본에 반영하기
		for (int i = left; i <= right; i++) {
			arr[i] = sortedArr[i];
		}

	}

}
