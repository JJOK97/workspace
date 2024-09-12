import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] map;
    static List<Shark> sharks;

    static class Shark {
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z) {
            this.r = r; this.c = c; this.s = s; this.d = d; this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        sharks = new ArrayList<>();
        sharks.add(null);  // 0번 인덱스는 사용하지 않음

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            sharks.add(new Shark(r, c, s, d, z));
            map[r][c] = i;
        }

        int result = 0;
        for (int fisher = 1; fisher <= C; fisher++) {
            // 상어 잡기
            for (int i = 1; i <= R; i++) {
                if (map[i][fisher] != 0) {
                    result += sharks.get(map[i][fisher]).z;
                    sharks.set(map[i][fisher], null);
                    map[i][fisher] = 0;
                    break;
                }
            }

            // 상어 이동
            int[][] newMap = new int[R + 1][C + 1];
            for (int i = 1; i < sharks.size(); i++) {
                Shark shark = sharks.get(i);
                if (shark == null) continue;

                moveShark(shark);

                if (newMap[shark.r][shark.c] == 0 || sharks.get(newMap[shark.r][shark.c]).z < shark.z) {
                    if (newMap[shark.r][shark.c] != 0) {
                        sharks.set(newMap[shark.r][shark.c], null);
                    }
                    newMap[shark.r][shark.c] = i;
                } else {
                    sharks.set(i, null);
                }
            }
            map = newMap;
        }

        System.out.println(result);
    }

    private static void moveShark(Shark shark) {
        int move = shark.d <= 2 ? shark.s % ((R - 1) * 2) : shark.s % ((C - 1) * 2);
        
        while (move > 0) {
            if (shark.d == 1 && shark.r == 1) shark.d = 2;
            else if (shark.d == 2 && shark.r == R) shark.d = 1;
            else if (shark.d == 3 && shark.c == C) shark.d = 4;
            else if (shark.d == 4 && shark.c == 1) shark.d = 3;

            if (shark.d == 1) shark.r--;
            else if (shark.d == 2) shark.r++;
            else if (shark.d == 3) shark.c++;
            else if (shark.d == 4) shark.c--;

            move--;
        }
    }
}