import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static int[][] array, originalArray;
    static List<int[]> operations = new ArrayList<>();
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 및 회전 연산 수 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        originalArray = new int[N][M];

        // 배열 A 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                originalArray[i][j] = array[i][j]; // 원본 배열 저장
            }
        }

        // 회전 연산 정보 입력 받기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            operations.add(new int[]{r, c, s});
        }

        // 모든 순열에 대해 회전 연산을 수행
        permute(new ArrayList<>(), new boolean[K]);

        // 결과 출력
        System.out.println(result);
    }

    // 순열 생성
    public static void permute(List<int[]> perm, boolean[] visited) {
        if (perm.size() == K) {
            // 배열을 회전 연산에 따라 돌리고 최소값을 계산
            applyOperations(perm);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm.add(operations.get(i));
                permute(perm, visited);
                perm.remove(perm.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 회전 연산 적용
    public static void applyOperations(List<int[]> perm) {
        // 배열을 원본으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = originalArray[i][j];
            }
        }

        // 순서에 따라 회전 연산 적용
        for (int[] op : perm) {
            rotate(op[0], op[1], op[2]);
        }

        // 최소 행합 계산
        result = Math.min(result, findMinValue());
    }

    // 회전 연산 수행
    public static void rotate(int r, int c, int s) {
        for (int i = 1; i <= s; i++) {
            int top = r - i, bottom = r + i;
            int left = c - i, right = c + i;

            int temp = array[top][left]; // 가장 왼쪽 위의 값을 임시 저장

            // 왼쪽 열 이동
            for (int j = top; j < bottom; j++) {
                array[j][left] = array[j + 1][left];
            }

            // 아래쪽 행 이동
            for (int j = left; j < right; j++) {
                array[bottom][j] = array[bottom][j + 1];
            }

            // 오른쪽 열 이동
            for (int j = bottom; j > top; j--) {
                array[j][right] = array[j - 1][right];
            }

            // 위쪽 행 이동
            for (int j = right; j > left; j--) {
                array[top][j] = array[top][j - 1];
            }

            array[top][left + 1] = temp; // 임시 저장한 값을 제자리에 놓음
        }
    }

    // 배열 A의 값(최소 행합) 찾기
    public static int findMinValue() {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += array[i][j];
            }
            minValue = Math.min(minValue, rowSum);
        }

        return minValue;
    }
}