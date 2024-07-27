import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<List<Integer>> graph;
    static int totalPopulation = 0;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 인구 정보와 그래프 초기화
        population = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        // 인구 정보 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            totalPopulation += population[i];
        }

        // 그래프 정보 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int neighbor = Integer.parseInt(st.nextToken());
                graph.get(i).add(neighbor);
            }
        }

        // 모든 가능한 분할 탐색 시작
        divide(1, 0);

        // 결과 출력
        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    // 비트마스킹을 이용한 모든 가능한 분할 생성
    static void divide(int index, int mask) {
        if (index > N) {
            // 모든 구역을 고려했을 때
            if (mask != 0 && mask != ((1 << N) - 1)) {
                // 두 선거구 모두 연결되어 있는지 확인
                if (isConnected(mask) && isConnected(((1 << N) - 1) ^ mask)) {
                    int diff = calculateDifference(mask);
                    minDifference = Math.min(minDifference, diff);
                }
            }
            return;
        }

        // 현재 구역을 선거구 A에 포함
        divide(index + 1, mask | (1 << (index - 1)));
        // 현재 구역을 선거구 B에 포함
        divide(index + 1, mask);
    }

    // BFS를 이용해 선거구의 연결성 확인
    static boolean isConnected(int mask) {
        int start = 1;
        while (start <= N && ((mask & (1 << (start - 1))) == 0)) start++;
        if (start > N) return false;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (!visited[next] && ((mask & (1 << (next - 1))) != 0)) {
                    queue.offer(next);
                    visited[next] = true;
                    count++;
                }
            }
        }

        return count == Integer.bitCount(mask);
    }

    // 두 선거구의 인구 차이 계산
    static int calculateDifference(int mask) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if ((mask & (1 << (i - 1))) != 0) {
                sum += population[i];
            }
        }
        return Math.abs(totalPopulation - 2 * sum);
    }
}