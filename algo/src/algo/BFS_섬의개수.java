package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_섬의개수 {

	static int w, h, count;
	static int map[][];
	static boolean visit[][];

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		w = sc.nextInt();
		h = sc.nextInt();

		while (w != 0 && h != 0) {

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			visit = new boolean[h][w];

			count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (!visit[i][j] && map[i][j] == 1) {
						count++;
						BFS(i, j);
					}

				}
			}
			
			System.out.println(count);
			w = sc.nextInt();
			h = sc.nextInt();

		}
	}

	private static void BFS(int x, int y) {

		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visit[x][y] = true;

		while (!q.isEmpty()) {

			Node node = q.poll();

			for (int idx = 0; idx < 8; idx++) {

				int dX = node.x + dx[idx];
				int dY = node.y + dy[idx];

				if (0 <= dX && 0 <= dY && dX < h && dY < w && !visit[dX][dY] && map[dX][dY] == 1) {
					visit[dX][dY] = true;
					q.offer(new Node( dX, dY ));
				}

			}

		}

	}

}
