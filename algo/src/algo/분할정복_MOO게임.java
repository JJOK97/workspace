package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분할정복_MOO게임 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// S[0]일 때, 문자열의 총 길이
		int pre = 3;
		// S[k-1]의 마지막 index
		int post = 3;
		// index
		int k = 0;

		// n의 범위를 구해주기
		while (pre < n) {
			k++;
			pre = 2 * post + (1 + 2 + k);
			post = pre;
		}
		
		// 재귀함수에 시작값으로 넣어주기 위해 preK 을 다시 구함
		post = (pre - (1 + 2 + k)) / 2;

		char c = ' ';

		// 입력된 숫자가 3 이하일 경우
		if (k == 0) {
			if (n == 1)
				c = 'm';
			else
				c = 'o';
		} else {
			// 3보다 클 경우
			if (post + 1 <= n && n < post + (1 + 2 + k)) {
				if (post + 1 == n) {
					c = 'm';
				} else
					c = 'o';
			} else
				c = moo(post + 1 + (1 + 2 + k), k - 1, pre);
		}

		System.out.println(c);

	}

	// 시작 index, k 값, 끝 index
	private static char moo(int si, int k, int se) {

		// 중간 moo의 크기 구하기
		int index = ((se - si + 1 - (k + 3)) / 2);

		// 기저조건
		if (k == 0) {
			if (n == si)
				return 'm';
			else
				return 'o';
		} else {

			// 왼쪽인 경우
			if (si <= n && n < si + index) {
				if (si == n)
					return 'm';
				return moo(si, k - 1, si + index - 1);
				// else return 'o';
			}
			// 오른쪽인 경우
			else if (si + index + (k + 3) <= n && n <= se) {
				if (si + index + (k + 3) == n)
					return 'm';
				else
					return moo(si + index + (k + 3), k - 1, se);
			}
			// 가운데
			else {
				if (si + index == n)
					return 'm';
				else
					return 'o';
			}
		}

	}

}
