package algo;

import java.util.Scanner;
import java.util.Stack;

public class DFS_섬의개수2 {

	static int w, h, count;
	static int[][] map;
	static boolean[][] visit;
	
    static int dirX[] = {0, 0, -1 ,1, -1, 1, -1, 1};
    static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		w = sc.nextInt();
		h = sc.nextInt();

		while (w != 0 && h != 0) {

			map = new int[h][w];
			visit = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						count++;
						DFS(i, j);
					}
				}
			}
			
			System.out.println(count);
			
			w = sc.nextInt();
			h = sc.nextInt();

		}

	}

	private static void DFS(int i, int j) {

		Stack<int[]> stack = new Stack<>();
		visit[i][j] = true;
		stack.push(new int[] { i, j });

		while (!stack.isEmpty()) {

			int[] curr = stack.pop();
			int x = curr[0];
			int y = curr[1];
			
			for(int idx = 0; idx < 8; idx++) {
				
				int dX = dirX[idx] + x;
				int dY = dirY[idx] + y;
				
				if(0 <= dX && 0 <= dY &&  dY < w && dX < h && !visit[dX][dY] && map[dX][dY] == 1) {
	                stack.push(new int[]{dY, dX});
	                visit[dX][dY] = true;
				}
					
			}
			
		}

	}

}
