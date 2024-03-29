package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라_케빈베이컨 {
	static int N, M; // 유저의 수, 친구 관계의 수
	static ArrayList<ArrayList<Integer>> graph; // 그래프를 인접 리스트로 표현합니다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 유저의 수와 친구 관계의 수를 입력받습니다.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 각 유저와 그 친구 관계를 표현하기 위해 그래프를 초기화합니다.
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 친구 관계를 입력받아 그래프에 추가합니다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 양방향 그래프이므로 양쪽 모두에 추가합니다.
			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		int minBacon = Integer.MAX_VALUE; // 최소 케빈 베이컨 수를 저장하는 변수
		int minUser = 0; // 최소 케빈 베이컨 수를 갖는 유저를 저장하는 변수

		// 모든 유저에 대해 케빈 베이컨의 수를 구하고 최솟값을 찾습니다.
		for (int i = 1; i <= N; i++) {
			int bacon = calculateKevinBacon(i);
			if (bacon < minBacon) {
				minBacon = bacon;
				minUser = i;
			}
		}

		// 최소 케빈 베이컨 수를 갖는 유저를 출력합니다.
		System.out.println(minUser);
	}

	// 각 유저로부터 모든 다른 유저까지의 케빈 베이컨 수를 계산하는 메소드입니다.
	static int calculateKevinBacon(int start) {
		int[] dist = new int[N + 1]; // 각 유저로부터의 거리를 저장하는 배열
		Arrays.fill(dist, Integer.MAX_VALUE); // 거리를 최대값으로 초기화합니다.
		dist[start] = 0; // 자기 자신까지의 거리는 0으로 설정합니다.

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(start); // 시작 유저를 우선순위 큐에 추가합니다.

		// 다익스트라 알고리즘을 이용하여 최단 거리를 구합니다.
		while (!queue.isEmpty()) {
			int current = queue.poll(); // 우선순위 큐에서 현재 유저를 꺼냅니다.

			// 현재 유저와 친구인 다음 유저들에 대해 거리를 갱신합니다.
			for (int next : graph.get(current)) {
				if (dist[next] > dist[current] + 1) {
					dist[next] = dist[current] + 1;
					queue.offer(next); // 갱신된 유저를 우선순위 큐에 추가합니다.
				}
			}
		}

		// 모든 유저까지의 거리의 합을 반환합니다.
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += dist[i];
		}

		return sum;
	}
}
