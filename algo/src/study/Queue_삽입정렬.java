package study;

import java.util.Arrays;

public class Queue_삽입정렬 {

	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 7, 16, 8, 31, 22 };

		// 정렬되지 않은 집합(U)의 원소를 하나씩 순회
		for (int i = 1; i < data.length; i++) {
			int key = data[i];

			int j;
			// 정렬된 집합(S)의 원소와 뒤에서부터 비교하면서 위치를 찾는다.
			for (j = i - 1; j >= 0 && data[j] > key; j--) {
				data[j + 1] = data[j];
			}

			// 반복문 안에서 key가 들어갈 위치 찾았는데..

			data[j + 1] = key;

		}

		System.out.println(Arrays.toString(data));
	}

}
