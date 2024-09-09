import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visit;
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        while (true) {
            visit = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        int populationSum = bfs(i, j); // 해당 좌표에서 BFS 실행
                        if (populationSum > 0) { // 인구 이동이 발생했을 경우
                            isMoved = true;
                        }
                    }
                }
            }

            if (!isMoved) {
                break; // 더 이상 인구 이동이 발생하지 않으면 종료
            }

            result++;
        }

        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        List<int[]> union = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = true;
        union.add(new int[]{x, y});
        int sum = map[x][y];
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nX = curX + dX[i];
                int nY = curY + dY[i];

                if (nX >= 0 && nX < N && nY >= 0 && nY < N && !visit[nX][nY]) {
                    int diff = Math.abs(map[nX][nY] - map[curX][curY]);

                    if (L <= diff && diff <= R) { // 국경선을 열 수 있는지 확인
                        visit[nX][nY] = true;
                        q.add(new int[]{nX, nY});
                        union.add(new int[]{nX, nY});
                        sum += map[nX][nY]; // 연합 내 인구 합산
                        count++;
                    }
                }
            }
        }

        if (count > 1) { // 연합이 형성되었다면
            int avg = sum / count;
            for (int[] pos : union) {
                map[pos[0]][pos[1]] = avg; // 연합에 속한 국가들의 인구수 변경
            }
            return sum;
        }

        return 0;
    }
}