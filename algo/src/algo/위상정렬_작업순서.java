package algo;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬_작업순서 {

	public static int[] path;
	static int V, E;
	static int[][] adj;
	static int[] degree;
	static boolean[] visited; // 방문쳌
	static Stack<Integer> stack; // 할일을 담을 스택

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int idx = 1; idx <= 10; idx++) {

			V = sc.nextInt(); // 정점의수
			E = sc.nextInt(); // 간선의수 //방향있음

			path = new int[V + 1];
			
			for(int i = 1; i < V + 1; i++) {
				path[i] = i;
			}
			
			adj = new int[V + 1][V + 1]; // 정점의 번호가 1번부터 시작이야
			degree = new int[V + 1]; // 진입차수 저장
			visited = new boolean[V + 1];
			stack = new Stack<>();

			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				adj[A][B] = 1; // 가중치가 따로 없기 때문에 1로 표기, 유향이니 반대는 처리 X
				// 진입차수를 증가
				degree[B]++;
			} // 입력

			for (int i = 1; i < V + 1; i++) {
				// 진입차수가 0인 정점들을 전부다 DFS 탐색 하겠다.
				if (degree[i] == 0)
					DFS(i);
			}

			System.out.printf("#%d ",idx);
			// 해당라인 수행된다는 뜻은 위상정렬 끝 해당 작업은 stack 몽땅 들어있음
			while (!stack.isEmpty()) {
				System.out.print(path[stack.pop()] + " ");
			}
			System.out.println();
		}

	}

	static void DFS(int v) {
		visited[v] = true; // 방문쳌

		for (int i = 1; i < V + 1; i++) {
			// 인접하고, 방문하지 않은 점이 있다면 방문
			if (adj[v][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}

		// 해당 라인이 실행된다는 뜻은! 할거 다했어 갈수 있는거 전부 다녀왔어
		stack.add(v); // 나이제 들어간다.
	}

}
