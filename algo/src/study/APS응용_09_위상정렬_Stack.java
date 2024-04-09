package study;

import java.util.Scanner;
import java.util.Stack;

public class APS응용_09_위상정렬_Stack {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static int V, E;
	static int[][] adj;
	static int[] degree;
	static boolean[] visited; // 방문쳌
	static Stack<Integer> stack; // 할일을 담을 스택

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt(); // 정점의수
		E = sc.nextInt(); // 간선의수 //방향있음

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

		// 해당라인 수행된다는 뜻은 위상정렬 끝 해당 작업은 stack 몽땅 들어있음
		while (!stack.isEmpty()) {
			System.out.println(cook[stack.pop()]);
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

	static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n" + "5 6\r\n"
			+ "9 6\r\n" + "6 7\r\n" + "";
}
