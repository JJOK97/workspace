package study;

import java.util.Arrays;

public class 다음순열 {

	public static void main(String[] args) {

		// next permutation
		// 주어진 순열(임의의 순열) 이것보다 바로 다음 큰 수를 찾는 것
		// 같은 것을 포함하는 순열을 찾을 때 활용

		// 다음 순열 알고리즘
		// 뒤에서부터 꼭대기(A)를 찾는다. 증가하다가 감소하기 직전.
		// 2. 낭떠러지 : 처음으로 감소하는 수(B)

		// => 꼭대기 이하의 수는 내림차순 정렬( 그 숫자들로 만들 수 있는 최대의 수)
		// => 낭떠러지는 최고차 자리수 => 한 칸 올려줄 수 밖에 없음
		// 3. 다시 뒤에서 탐색하면서 낭떠러지(B)보다 커지는 최초의 수(C)를 찾는다.
		// 4. B와 C의 위치를 교환
		// 5. 꼭대기 이하의 수를 가장 작은 수로 만들어준다 (내림차순 => 오름차순)

		int[] arr = { 1, 2, 3, 4 }; // 오름차순 정렬된 상태로 출발

		do {
			System.out.println(Arrays.toString(arr));
		} while (np(arr));

	}

	// np : 다음 순열을 만드는 함수
	// 만약에 다음순열을 만들었으면, true;
	// 못 만들었으면 false(더 이상 다음 순열이 없음)
	private static boolean np(int[] arr) {

		// 1. 꼭대기 찾기
		int i = arr.length - 1; // 맨 뒤부터 출발
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		if (i == 0)
			return false; // 곡대기가 첫 번째 수라면, 아마 가장 큰 수이므로 다음 순열이 없음.

		// 꼭대기(A) : i번째 위치
		// 낭떠러지(B) : i-1번째 위치

		// 2. 뒤에서부터 탐색하면서 낭떠러지보다 커지는 최초의 수 찾기
		int j = arr.length - 1;
		while (arr[i - 1] >= arr[j])
			j--;
		
		// 3. B와 C교환
		swap(arr, i-1, j);
		
		// 4. 역순으로 뒤집기(그 밑을 최소값으로 만들어준다.)
		// [ 꼭대기 ~ 가장 끝 ]
		// [ i ~ arr.length - 1]
		int k = arr.length - 1;
		while ( i < k ) swap ( arr, i++, k--);

		return false;

	}
	
	private static void swap(int[]arr, int i, int j) {
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}

}
