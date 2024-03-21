package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BFS_치즈 {

    static int N, M, prevCount, count, time;
    static int[][] cheeze;
    static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
    static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeze = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            setCheeze();
            prevCount = countCheeze();
            meltingCheeze();

            if (countCheeze() == 0) {
                break;
            }
        }

        System.out.println(time);
        System.out.println(prevCount);
    }

    private static void setCheeze() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeze[i][j] == 0) {
                    boolean allOnes = true;
                    for (int dir = 0; dir < 4; dir++) {
                        int ni = i + dr[dir];
                        int nj = j + dc[dir];
                        boolean check = true;
                        while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            if (cheeze[ni][nj] == 1) {
                                check = false;
                                break;
                            }
                            ni += dr[dir];
                            nj += dc[dir];
                        }
                        if (check) {
                            allOnes = false;
                            break;
                        }
                    }
                    if (allOnes) {
                        cheeze[i][j] = 2;
                    }
                } else if (cheeze[i][j] == 2) {
                    boolean allOnes = true;
                    for (int dir = 0; dir < 8; dir++) {
                        int ni = i + dr[dir];
                        int nj = j + dc[dir];
                        boolean check = true;
                        while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                            if (cheeze[ni][nj] == 1) {
                                check = false;
                                break;
                            }
                            ni += dr[dir];
                            nj += dc[dir];
                        }
                        if (check) {
                            allOnes = false;
                            break;
                        }
                    }
                    if (!allOnes) {
                        cheeze[i][j] = 0;
                    }
                }
            }
        }
    }


    private static int countCheeze() {
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeze[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private static void meltingCheeze() {
        boolean[][] meltingCheeze = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cheeze[i][j] == 1) {
                    boolean hasZero = false;
                    for (int dir = 0; dir < 4; dir++) {
                        int ni = i + dr[dir];
                        int nj = j + dc[dir];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && cheeze[ni][nj] == 0) {
                            hasZero = true;
                            break;
                        }
                    }
                    if (hasZero) {
                        meltingCheeze[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (meltingCheeze[i][j]) {
                    cheeze[i][j] = 0;
                }
            }
        }

        time++;
    }

}
