	package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정사각형의방 {

    static int[][] 배열;
    static int[] deltaRow = { -1, 0, 1, 0 }, deltaCol = { 0, -1, 0, 1 };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int 테스트케이스 = Integer.parseInt(br.readLine());

        for (int index = 1; index <= 테스트케이스; index++) {

            int N = Integer.parseInt(br.readLine());

            배열 = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    배열[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int 최댓값;
            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int 카운트 = 1;
                    int 현재값 = 배열[i][j];
                    int 다음값 = 현재값 + 1;
                    int 현재행 = i;
                    int 현재열 = j;

                    while (true) {
                        boolean 이동 = false;
                        for (int d = 0; d < 4; d++) {
                            int 행 = 현재행 + deltaRow[d];
                            int 열 = 현재열 + deltaCol[d];
                            if (행 >= 0 && 행 < N && 열 >= 0 && 열 < N && 배열[행][열] == 다음값) {
                                카운트++;
                                다음값++;
                                현재행 = 행;
                                현재열 = 열;
                                이동 = true;
                                break;
                            }
                        }
                        if (!이동) break;
                    }

                    if (카운트 > 최댓값 || (카운트 == 최댓값 && 현재값 < result)) {
                        최댓값 = 카운트;
                        result = 현재값;
                    }
                }
            }
            System.out.printf("#%d %d %d\n", index, result, 최댓값);
        }
    }
}
