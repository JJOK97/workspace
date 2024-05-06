import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, count, result;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 1;
		
		for (int idx = 1; idx < 101; idx++) {
			visit = new boolean[N][N];
			count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > idx && !visit[i][j]) {
						BFS(i, j, idx);
						count++;
					}
				}
			}
			
			result = result < count ? count : result;
		}
		
		System.out.println(result);

	}

	static void BFS(int i, int j, int idx) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { i, j });
		visit[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int z = 0; z < 4; z++) {
				int nx = cur[0] + dx[z];
				int ny = cur[1] + dy[z];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && map[nx][ny] > idx) {
					visit[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}

	}

}