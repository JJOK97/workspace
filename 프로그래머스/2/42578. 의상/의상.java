import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별로 해시맵으로 개수를 셉니다.
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        // 의상 데이터를 해시맵에 저장
        for (String[] item : clothes) {
            String type = item[1]; // 의상 종류
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // DP 배열을 초기화. 의상 종류별로 계산된 값을 저장할 공간.
        int[] dp = new int[clothesMap.size() + 1];
        dp[0] = 1;  // 아무것도 선택하지 않은 경우는 1가지 방법
        
        // 해시맵의 각 의상 종류와 그 개수를 돌면서 경우의 수를 누적합니다.
        int i = 1;
        for (int count : clothesMap.values()) {
            dp[i] = dp[i - 1] * (count + 1);  // 이전까지의 경우에 현재 의상 종류 선택을 곱함
            i++;
        }
        
        // 최종적으로 모든 경우의 수에서 아무것도 입지 않은 경우를 제외해야 함
        return dp[clothesMap.size()] - 1;
    }
}
