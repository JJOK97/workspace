package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS와BFS {

	static int N, M, V;
	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int V1 = Integer.parseInt(st.nextToken());
			int V2 = Integer.parseInt(st.nextToken());

			map[V1][V2] = map[V2][V1] = 1;
		}

		dfs(V);

		System.out.println();

		bfs(V);
	}

	private static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();

		visit = new boolean[N + 1];

		stack.push(start);
		visit[start] = true;
		System.out.print(start + " ");

		while (!stack.isEmpty()) {
			int current = stack.peek();
			boolean flag = false;

			for (int i = 1; i < map.length; i++) {

				if (map[current][i] == 1 && !visit[i]) {

					stack.push(i);
					visit[i] = true;
					System.out.print(i + " ");

					flag = true;
					break;

				}
			}

			if (!flag) {
				stack.pop();
			}

		}
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visit = new boolean[N + 1];
		queue.offer(start);
		visit[start] = true;
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 1; i < map.length; i++) {
				if (map[current][i] == 1 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
