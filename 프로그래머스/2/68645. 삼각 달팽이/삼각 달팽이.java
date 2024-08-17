import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int[] directionsRow = {1, 0, -1};
        int[] directionsCol = {0, 1, -1};
        int currentDirection = 0;
        int row = 0, col = 0;
        int currentNum = 1;

        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                matrix[row][col] = currentNum++;
                if (i == 1) break;
                int newRow = row + directionsRow[currentDirection];
                int newCol = col + directionsCol[currentDirection];
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || matrix[newRow][newCol] != 0) {
                    currentDirection = (currentDirection + 1) % 3;
                    newRow = row + directionsRow[currentDirection];
                    newCol = col + directionsCol[currentDirection];
                }
                row = newRow;
                col = newCol;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result.add(matrix[i][j]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result1 = solution(4);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] result2 = solution(5);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] result3 = solution(6);
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
