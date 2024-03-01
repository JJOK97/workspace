package study;

import java.util.Arrays;

public class 분할정복_이진검색_API {
	
	static int[] arr;
	static int key;

	public static void main(String[] args) {

		// 정렬된 상태라고 가정 // 정렬을 따로 해줘야 한다.
		arr = new int[] { 2, 4, 6, 8, 9, 17, 28 };
		key = 7;
		
		// 있는 키를 찾으면 해당 index를 반환해준다.
		// 없는 키를 찾으면 이상한 음수값을 반환해준다. 7 -> -4 / 3 -> -2 /
		// 음수가 나오는데 어떠한 규칙이 있다!!
		System.out.println(Arrays.binarySearch(arr, key));

	}


}
