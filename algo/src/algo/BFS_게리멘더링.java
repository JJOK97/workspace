package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BFS_게리멘더링 {

	static int N, result;
	static int[] arr;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		graph = new int[N + 1][N];
		visit = new boolean[N+1];
		result = -1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for(int i = 1; i < N; i++) {
			dfs(i);
		}
		
	}
	
	private static void dfs(int start) {
		
		Stack<Integer> s = new Stack<>();
		visit[start] = true;
		s.push(start);
		
		while(!s.isEmpty()) {
			
			for(int i = 0; i < N; i++) {
				
			}
			
		}
		
	}

}