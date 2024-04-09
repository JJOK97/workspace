package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BFS_말이되고픈원숭이2 {

	static int k, w, h;

	static int[][] map;
	static boolean[][][] visited;

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] hx = { -1, -2, 1, 2, -2, -1, 1, 2 };
	static int[] hy = { -2, -1, -2, -1, 1, 2, 2, 1 };

	public static class Spot {
		int x;
		int y;
		int count;
		int k;

		public Spot(int x, int y, int count, int k) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.k = k;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		w = Integer.parseInt(input[0]);
		h = Integer.parseInt(input[1]);

		map = new int[h][w];
		for (int i = 0; i < h; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[h][w][k + 1];
		int answer = bfs(0, 0);

		if (answer == -1) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	public static int bfs(int x, int y) {
		Queue<Spot> q = new LinkedList<>();
		q.offer(new Spot(x, y, 0, k));
		visited[x][y][k] = true;

		while (!q.isEmpty()) {
			Spot current = q.poll();
			if (current.x == h - 1 && current.y == w - 1)
				return current.count;

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][current.k] && map[nx][ny] == 0) {
					visited[nx][ny][current.k] = true;
					q.offer(new Spot(nx, ny, current.count + 1, current.k));
				}
			}

			if (current.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = current.x + hx[i];
					int ny = current.y + hy[i];
					if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][current.k - 1] && map[nx][ny] == 0) {
						visited[nx][ny][current.k - 1] = true;
						q.offer(new Spot(nx, ny, current.count + 1, current.k - 1));
					}
				}
			}
		}
		return -1;
	}
	
}