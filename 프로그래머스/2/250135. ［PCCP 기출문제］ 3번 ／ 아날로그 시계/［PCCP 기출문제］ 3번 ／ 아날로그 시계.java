public class Solution {

    // 주어진 시작시각(h1, m1, s1)부터 종료시각(h2, m2, s2)까지 알람이 울리는 횟수를 구하는 함수
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        // 입력시각을 초 단위로 변환 (0시 0분 0초를 0초로 함)
        long T1 = h1 * 3600L + m1 * 60L + s1;
        long T2 = h2 * 3600L + m2 * 60L + s2;
        
        // 초침-분침이 겹치는 시각: t = k * (3600/59)  (k ∈ ℤ)
        long countMinute = countEvents(T1, T2, 3600, 59);
        // 초침-시침이 겹치는 시각: t = k * (43200/719)  (k ∈ ℤ)
        long countHour = countEvents(T1, T2, 43200, 719);
        // 세 손이 모두 겹치는 시각은 두 이벤트 모두에 포함되므로 한 번만 세야 합니다.
        // 세 손이 겹치는 시각은 t = n * 43200 (n ∈ ℤ) 입니다.
        long countCommon = countCommonEvents(T1, T2);
        
        return (int)(countMinute + countHour - countCommon);
    }
    
    /**
     *  주어진 구간 [T1, T2] (초 단위) 내에,
     *  이벤트 시각 t = k * (A/B) (k ∈ ℤ)가 몇 번 발생하는지 세는 함수.
     *  
     *  T1 ≤ k*(A/B) ≤ T2 인 정수 k의 개수를 구합니다.
     *  양변에 B를 곱하면, T1*B ≤ k*A ≤ T2*B 가 되므로,
     *  k는 k ≥ ceil(T1*B/A) 그리고 k ≤ floor(T2*B/A)를 만족합니다.
     */
    private long countEvents(long T1, long T2, long A, long B) {
        long k_min = ceilDiv(T1 * B, A);
        long k_max = (T2 * B) / A;  // 정수 나눗셈은 양수에 대해 내림(floor) 효과가 있습니다.
        if (k_min > k_max) return 0;
        return k_max - k_min + 1;
    }
    
    /**
     *  세 손(시, 분, 초)이 동시에 겹치는 시각은 t = n * 43200 (n ∈ ℤ) 입니다.
     *  [T1, T2] 구간에 해당하는 n의 개수를 구합니다.
     */
    private long countCommonEvents(long T1, long T2) {
        long n_min = ceilDiv(T1, 43200);
        long n_max = T2 / 43200;  // floor(T2/43200)
        if (n_min > n_max) return 0;
        return n_max - n_min + 1;
    }
    
    // 양의 정수 a, b에 대해 ceil(a/b)를 구하는 함수
    private long ceilDiv(long a, long b) {
        return (a + b - 1) / b;
    }
    
  
}
