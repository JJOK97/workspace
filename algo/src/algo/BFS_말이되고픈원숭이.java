package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_말이되고픈원숭이 {

	static int K, W, H;

	static int[][] map;
	static boolean[][][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] hx = { -1, -2, 1, 2, -2, -1, 1, 2 };
	static int[] hy = { -2, -1, -2, -1, 1, 2, 2, 1 };

	static class Spot {

		int x;
		int y;
		int cnt;
		int k;

		Spot(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		W = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = bfs(0, 0);

		if (answer == -1) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	private static int bfs(int x, int y) {

		Queue<Spot> que = new LinkedList<>();

		que.offer(new Spot(x, y, 0, K));
		visited[x][y][K] = true;

		while (!que.isEmpty()) {
			Spot s = que.poll();

			int curX = s.x;
			int curY = s.y;

			if (curX == H - 1 && curY == W - 1) {
				return s.cnt;
			}

			for (int t = 0; t < 4; t++) {
				int nx = curX + dx[t];
				int ny = curY + dy[t];

				if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][s.k] && map[nx][ny] == 0) {
					visited[nx][ny][s.k] = true;
					que.offer(new Spot(nx, ny, s.cnt + 1, s.k));
				}

			}

			if (s.k > 0) {
				for (int t = 0; t < 8; t++) {
					int nx = curX + hx[t];
					int ny = curY + hy[t];

					if (nx >= 0 && ny >= 0 && nx < H && ny < W && !visited[nx][ny][s.k - 1] && map[nx][ny] == 0) {
						visited[nx][ny][s.k - 1] = true;
						que.offer(new Spot(nx, ny, s.cnt + 1, s.k - 1));
					}

				}
			}

		}
		return -1;

	}

}
