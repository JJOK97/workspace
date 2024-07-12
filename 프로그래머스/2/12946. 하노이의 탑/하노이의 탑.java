import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<int[]> solution(int n) {
        List<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, 2, result);
        return result;
    }

    private void hanoi(int n, int start, int end, int via, List<int[]> result) {
        if (n == 1) {
            result.add(new int[] {start, end});
        } else {
            hanoi(n - 1, start, via, end, result);
            result.add(new int[] {start, end});
            hanoi(n - 1, via, end, start, result);
        }
    }

    public static void main(int args) {
        Solution sol = new Solution();
        List<int[]> result = sol.solution(args);
        for (int[] move : result) {
            System.out.println("[" + move[0] + ", " + move[1] + "]");
        }
    }
}