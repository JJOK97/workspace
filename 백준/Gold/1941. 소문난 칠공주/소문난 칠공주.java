import java.util.*;
import java.io.*;

public class Main {

    static char[][] princess = new char[5][5];
    static int[] dX = {-1, 1, 0, 0};
    static int[] dY = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                princess[i][j] = line.charAt(j);
            }
        }

        combination(new ArrayList<>(), 0, 0);

        System.out.println(result);
    }

    private static void combination(List<int[]> selected, int start, int depth) {
        if (depth == 7) {
            if (isConnected(selected)) {
                result++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;
            selected.add(new int[]{x, y});
            combination(selected, i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static boolean isConnected(List<int[]> selected) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(selected.get(0));
        visited[selected.get(0)[0]][selected.get(0)[1]] = true;
        int count = 1;
        int sCount = princess[selected.get(0)[0]][selected.get(0)[1]] == 'S' ? 1 : 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dX[i];
                int ny = y + dY[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    for (int[] pos : selected) {
                        if (pos[0] == nx && pos[1] == ny) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny});
                            count++;
                            if (princess[nx][ny] == 'S') {
                                sCount++;
                            }
                        }
                    }
                }
            }
        }

        return count == 7 && sCount >= 4;
    }
}