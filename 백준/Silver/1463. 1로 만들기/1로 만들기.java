import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];

        dp[1] = 0; // 1은 이미 1이므로 연산 횟수는 0

        for (int i = 2; i <= n; i++) {
            // 현재 숫자에서 1을 빼는 경우
            dp[i] = dp[i - 1] + 1;

            // 현재 숫자가 2 또는 3으로 나누어 떨어지는 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[n]);
    }
}