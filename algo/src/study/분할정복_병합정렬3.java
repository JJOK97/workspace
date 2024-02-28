package study;

import java.util.Arrays;

public class 분할정복_병합정렬3 {
	public static void main(String[] args) {
		// 병합정렬
		// - 분할정복 - 정렬
		// - Arrays.sort()
		// - O(nlogn)

		// - 아이디어: 이미 정렬된 두개의 배열이 있다면
		// 이 둘을 합쳐서 새로운 정렬된 배열을 만드는 것은 쉽다(O(n))

		int[] L = { 3, 6, 11, 33, 75 };
		int[] R = { 1, 23, 42, 55, 66 };

		// int[] A = { 1, 3, 6, 11, 23,
		// 두 수를 비교해서 작은 수를 순서대로 써 나가면 된다.

		int[] A = new int[L.length + R.length]; // 새로 만들 배열.

		// 포인터(idx를 가리는 변수)
		int i = 0; // L
		int j = 0; // R
		int k = 0; // A

		// L의 i번째와 R의 j번째를 비교해서 작은 수를 A의 k번째에 넣는다.

		while (i < L.length && j < R.length) { // 두 수를 비교할 수 있다면.
			if (L[i] < R[j])
				A[k++] = L[i++];
			else
				A[k++] = R[j++];
		}
		// i 또는 j가 배열의 범위 밖으로 벗어낫다.
		for (; i < L.length; i++)
			A[k++] = L[i];

		for (; j < R.length; j++)
			A[k++] = R[j];

		System.out.println(Arrays.toString(A));

	}

	// 주어진 배열 A에서
	// L : [l, m], R : [m+1, r] 두 구간을 합친다. => [l, r]
	// L, R은 이미 정렬된 배열 => [l, r] : 정렬된 배열
	// 원본 배열은 A를 통째로 복사하는 것이 아니라, [l, r]까지의 구간만 복사해서 사용
	private static void merge(int[] a, int l, int m, int r) {

		// 원본 배열 A로부터 복사하여 배열 L, R 만들기
		int n1 = m - l + 1; // 배열 L의 크기
		int n2 = r - m; // 배열 R의 크기

		int[] L = new int[n1];
		int[] R = new int[n2];

		// 원본 배열 A에서 복사해서 L, R만들기
		for (int i = 0; i < n1; i++)
			L[i] = a[l + i];
		for (int i = 0; i < n2; i++)
			R[i] = a[m+1 + i];
		
		// 합치면서 원본 배열을 덮어 씀
		int i = 0, j = 0;
		int k = l; // 원ㅂ혼 배열의 [l, r] 부분을 덮어쓴다.
		 
		
		while (i < n1 && j < n2) {
			if(L[i] < R[i++])
				a[k++] = L[i++];
			else
				a[k++] = R[j++];
		}
		
		for(; l < n1; i++)a[k++] = L[i];

	}
}
