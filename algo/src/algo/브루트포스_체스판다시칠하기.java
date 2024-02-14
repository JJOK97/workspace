package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 브루트포스_체스판다시칠하기 {

    static char[][] chessBoard;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                chessBoard[i][j] = line.charAt(j);
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                result = Math.min(result, count(chessBoard, i, j));
            }
        }

        System.out.println(result);
    }

    public static int count(char[][] chessBoard, int startRow, int startCol) {
        int count1 = 0;
        int count2 = 0;

        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if(chessBoard[i][j] == 'B') count1++;
                } else {
                    if(chessBoard[i][j] == 'W') count1++;
                }
                
                if ((i + j) % 2 == 0) {
                    if(chessBoard[i][j] == 'W') count2++;
                } else {
                    if(chessBoard[i][j] == 'B') count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}
