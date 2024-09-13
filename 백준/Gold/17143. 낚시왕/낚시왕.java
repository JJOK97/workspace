import java.io.*;
import java.util.*;

public class Main {
    static int R, C, M;
    static List<Integer>[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new ArrayList<>(Arrays.asList(r, c, s, d, z));
        }

        int result = 0;

        for (int fisher = 1; fisher <= C; fisher++) {
            // 1. 상어 잡기
            for (int i = 1; i <= R; i++) {
                if (map[i][fisher] != null) {
                    result += map[i][fisher].get(4);
                    map[i][fisher] = null;
                    break;
                }
            }

            // 2. 상어 이동
            List<Integer>[][] newMap = new ArrayList[R + 1][C + 1];
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] != null) {
                        List<Integer> shark = new ArrayList<>(map[i][j]);
                        moveShark(shark);

                        int nr = shark.get(0), nc = shark.get(1);
                        if (newMap[nr][nc] == null || newMap[nr][nc].get(4) < shark.get(4)) {
                            newMap[nr][nc] = shark;
                        }
                    }
                }
            }
            map = newMap;
        }

        System.out.println(result);
    }

    private static void moveShark(List<Integer> shark) {
        int r = shark.get(0), c = shark.get(1), s = shark.get(2), d = shark.get(3);
        int distance = s;

        if (d <= 2) distance %= (R - 1) * 2;
        else distance %= (C - 1) * 2;

        for (int i = 0; i < distance; i++) {
            if (d == 1 && r == 1) d = 2;
            else if (d == 2 && r == R) d = 1;
            else if (d == 3 && c == C) d = 4;
            else if (d == 4 && c == 1) d = 3;

            if (d == 1) r--;
            else if (d == 2) r++;
            else if (d == 3) c++;
            else if (d == 4) c--;
        }

        shark.set(0, r);
        shark.set(1, c);
        shark.set(3, d);
    }
}