package algo;

import java.util.ArrayList;
import java.util.Scanner;

public class 디저트카페 {

	// 우하 -> 좌하 -> 좌상 -> 우상
	// delta
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	static int[][] map;
	static int max;
	static int N;

	// dir : 0 -> 1 -> 2- > 3

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 맵의 크기

			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			max = -1;
			// 2차원 배열의 모든 점을 시작점으로 해서 탐색을 시작한다.
			// 탐색 할 때 방향 우하부터 시작한다.

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {

					// (r, c)를 기점으로 재귀적인 탐색 시작.
					// 재귀함수 설계.
					tour(r, c, r, c, 0, 0, new ArrayList<Integer>());

				}
			}

			System.out.println("#" + tc + " " + max);
		}

	}

	// 재귀함수 설계
	// 시작위치로 되돌아와야함. => 시작 위치를 기억해놔야 함 : or, oc
	// 현재 위치를 기억해놔야 함. cr, cc
	// 현재 방향도 기억해놔야 함. d
	// 지금까지 몇 개의 디저트를 먹었는지 기억 : cnt
	// 그동안 먹엇던 디저트의 번호도 기억해야 함. : new ArrayList<Integer>() list

	private static void tour(int or, int oc, int cr, int cc, int d, int cnt, ArrayList<Integer> list) {

		// 기저 조건
		// (or, oc) == (cr, cc), d == 3인 경우 시작점으로 돌아온 것이므로 종료
		if (or == cr && oc == cc && d == 3) {
			// cnt로 max값 업데이트
			if (cnt > max)
				max = cnt;
			return;
		}

		// 유도조건
		// 1. 기존 방향 그대로(d) 가기.
		int nr = cr + dr[d];
		int nc = cc + dc[d];

		// 경계 조건을 만족하고, 기존에 먹지 않았던 번호인 경우에만 탐색을 진행
		if (cr >= 0 && nr < N && nc >= 0 && nc < N && !list.contains(map[nr][nc])) {

			// 새로운 리스트를 만듦
			ArrayList<Integer> list2 = new ArrayList<>();

			// 기존 리스트 복사
			for (int l : list)
				list2.add(l);

			// 새로운 번호를 추가하고
			list2.add(map[nr][nc]);

			// 그 다음으로 진행.
			tour(or, oc, nr, nc, d, cnt + 1, list2);

		}

		// 2. 그 다음 방향으로 꺾어서 (d+1) 가기
		// d: 0, 1, 2인 경우만 꺽어서 갈 수 잇음.
		if (d < 3) {

			// 꺾어서 가는 경우의 좌표를 새로 만든다.
			nr = cr + dr[d + 1];
			nc = cc + dc[d];

			// 경계 조건을 만족하고, 기존에 먹지 않았던 번호인 경우에만 탐색을 진행
			if (cr >= 0 && nr < N && nc >= 0 && nc < N && !list.contains(map[nr][nc])) {

				// 새로운 리스트를 만듦
				ArrayList<Integer> list3 = new ArrayList<>();

				// 기존 리스트 복사
				for (int l : list)
					list3.add(l);

				// 새로운 번호를 추가하고
				list3.add(map[nr][nc]);

				// 그 다음으로 진행.
				tour(or, oc, nr, nc, d, cnt + 1, list3);
			}
		}

	}

}
