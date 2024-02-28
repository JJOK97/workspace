package study;

public class 분할정복_이진검색_재귀 {
	
	static int[] arr;
	static int key;

	public static void main(String[] args) {

		// 정렬된 상태라고 가정 // 정렬을 따로 해줘야 한다.
		arr = new int[] { 2, 4, 6, 8, 9, 17, 28 };
		key = 7;

	}

	public boolean binarySearch(int[] arr, int key) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == key)
				return true;
			else if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;

		}

		return false;
	}

}
