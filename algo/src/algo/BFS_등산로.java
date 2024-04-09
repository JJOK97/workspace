package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_등산로 {

	static int N, K, mv;
	static int curX, curY, nowX, nowY;
	static int maxCnt;
	static int map[][];
	
	private static Queue<int[][]> visited = new LinkedList<>();

	static int[] dX = { -1, 0, 0, 1 };
	static int[] dY = { 0, -1, 1, 0 };

	static class Node {
		int x;
		int y;
		int cnt;
		boolean check;
		int data;

		public Node(int x, int y, int cnt, boolean check, int data) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.check = check;
			this.data = data;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int index = 1; index <= T; index++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			mv = 0;
			maxCnt = 0;

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					mv = map[i][j] > mv ? map[i][j] : mv;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == mv) {
						
						int tmp[][] = new int[N][N]; 
						tmp[i][j] = 1;
						
						visited.offer(tmp);
						
						BFS(i, j);
					}
				}
			}

			System.out.println("#" + index + " " + maxCnt);

		}

	}

	private static void BFS(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 1, false, map[x][y]));

		while (!q.isEmpty()) {

			Node curr = q.poll();
			curX = curr.x;
			curY = curr.y;

			maxCnt = Math.max(maxCnt, curr.cnt);

			for (int i = 0; i < 4; i++) {
				nowX = curX + dX[i];
				nowY = curY + dY[i];

				if (range_check()) {

					if (curr.data > map[nowX][nowY]) {
						if (curr.check) {
							q.offer(new Node(nowX, nowY, curr.cnt + 1, true, map[nowX][nowY]));
						} else {
							q.offer(new Node(nowX, nowY, curr.cnt + 1, false, map[nowX][nowY]));
						}
					}

					for (int idx = 1; idx <= K; idx++) {
						if (!curr.check && curr.data > map[nowX][nowY] - idx) {
							q.offer(new Node(nowX, nowY, curr.cnt + 1, true, map[nowX][nowY] - idx));
						}
					}

				}
			}

		}

	}

	private static boolean range_check() {
		return 0 <= nowX && nowX < N && 0 <= nowY && nowY < N;
	}
}
