//package algo;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BFS_다리만들기2 {
//
//	static int N, M;
//	static int map[][];
//	static boolean visit[][];
//
//	static int[] dX = { -1, 0, 0, 1 }; // 좌 상 하 우
//	static int[] dY = { 0, -1, 1, 0 }; // 좌 상 하 우
//
//	static int[] idX = { -2, 0, 0, 2 }; // 좌 상 하 우
//	static int[] idY = { 0, -2, 2, 0 }; // 좌 상 하 우
//
//	static class Node {
//
//		int N;
//		int M;
//
//		public Node(int N, int M) {
//			this.N = N;
//			this.M = M;
//		}
//
//	}
//
//	public static void main(String[] args) throws Exception {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//
//		map = new int[M][N];
//		visit = new boolean[M][N];
//
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < N; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				if (!visit[i][j] && map[i][j] == 1) {
//					island(i, j);
//				}
//			}
//		}
//
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//
//				for(int z = 0; z < 4; z++) {
//					int nowX = j + dX[z];
//					int nowY = i + dY[z];
//					
//					if (range_check(nowX, nowY) && !visit[nowY][nowX] && map[nowY][nowX] == 0) {
//						
//						findIsland(i, j);
//						
//					}
//					
//				}
//				
//			}
//		}
//
//	}
//
//	private static void island(int x, int y) {
//
//		Queue<Node> q = new LinkedList<>();
//		visit[x][y] = true;
//		q.offer(new Node(x, y));
//
//		while (!q.isEmpty()) {
//
//			Node curr = q.poll();
//			int curX = curr.M;
//			int curY = curr.N;
//
//			for (int i = 0; i < 4; i++) {
//
//				int nowX = curX + dX[i];
//				int nowY = curY + dY[i];
//
//				if (range_check(nowX, nowY) &&!visit[nowX][nowY] && map[nowX][nowY] == 1) {
//
//					visit[nowX][nowY] = true;
//					q.offer(new Node(nowX, nowY));
//
//				}
//
//			}
//
//		}
//
//	}
//	
//	private static boolean range_check(int x, int y) {
//		return 0 <= x && 0 <= y && x < M && y < N;
//	}
//
//}
