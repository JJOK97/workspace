//package algo;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class 재귀_쿼드트리 {
//
//	static int[][] arr;
//	static StringBuilder sb = new StringBuilder();
//
//	public static void main(String[] args) throws Exception {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int T = Integer.parseInt(br.readLine());
//
//		arr = new int[T][T];
//
//		for (int i = 0; i < T; i++) {
//
//			StringTokenizer st = new StringTokenizer(br.readLine());
//
//			for (int j = 0; j < T; j++) {
//
//				arr[i][j] = Integer.parseInt(st.nextToken());
//
//			}
//
//		}
//		
//		Node root = new Node(0, 0, T);
//		
//		dfs(0, 0, T / 2);
//		
//
//	}
//	
//	private static void dfs(int r_start, int c_start, int size) {		
//		if (isSame(r_start, c_start, size)) {
//			sb.append("(").append(arr[r_start][c_start]).append(")");
//			return;
//		}
//		
//		if (size == 1) {
//			
//			return;
//		}
//		
//		dfs(r_start, c_start, size / 2);
//		dfs(r_start, c_start + size, size / 2);
//		dfs(r_start + size, c_start, size / 2);
//		dfs(r_start + size, c_start + size, size / 2); 
//		
//	}
//
//	static class Node {
//		int r_start, c_start;
//		int size;
//		
//		Node top_left;
//		Node top_right;
//		Node bottom_left;
//		Node bottom_right;
//		
//		public Node(int r_start, int c_start, int size) {
//			super();
//			this.r_start = r_start;
//			this.c_start = c_start;
//			this.size = size;
//		}
//	}
//
//}
