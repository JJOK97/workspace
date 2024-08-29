import java.util.Scanner;

public class Main {
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        test(X, 0);
        System.out.println(answer);
    }

    public static void test(int X, int result) {
        if (X == 1) {
            answer = Math.min(answer, result);
            return;
        }

        if (result >= answer) {
            return;  // 가지치기: 이미 찾은 최소값보다 크거나 같으면 탐색 중단
        }

        if (X % 3 == 0) {
            test(X / 3, result + 1);
        }
        if (X % 2 == 0) {
            test(X / 2, result + 1);
        }
        test(X - 1, result + 1);
    }
}