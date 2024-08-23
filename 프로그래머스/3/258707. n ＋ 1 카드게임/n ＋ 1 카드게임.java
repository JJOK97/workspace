import java.util.*;

class Solution {
    
    public int solution(int coins, int[] cards) {
        int rounds = 0; // 최대 라운드를 기록할 변수
        
        int n = cards.length;
        int setting = n / 3; // 초기 카드 수
        Set<Integer> hand = new HashSet<>(); // 초기 손에 들고 있는 카드
        Set<Integer> roundCards = new HashSet<>(); // 각 라운드에서 추가된 카드들
        
        // 초기 손에 들고 있는 카드를 세팅
        for(int i = 0; i < setting; i++) {
            hand.add(cards[i]);
        }
        
        int targetSum = n + 1; // 각 라운드에서 카드 두 장의 합이 되어야 하는 목표 값
        
        // 게임 시작
        while (true) {
            rounds++;
            
            if (setting >= n) {
                // 모든 카드를 사용한 경우 종료
                break;
            }
            
            // 이번 라운드에서 두 장의 카드를 뽑음
            roundCards.add(cards[setting]);
            roundCards.add(cards[setting + 1]);
            setting += 2;
            
            boolean check = false; // 이번 라운드를 성공적으로 넘겼는지 확인
            
            // Step1. 손에 있는 카드로 해결 가능한지 확인
            for (int card : hand) {
                if (hand.contains(targetSum - card)) {
                    hand.remove(card);
                    hand.remove(targetSum - card);
                    check = true;
                    break;
                }
            }
            
            // Step2. 손에 있는 카드만으로 해결 불가능한 경우
            if (!check && coins > 0) {
                for (int card : hand) {
                    if (roundCards.contains(targetSum - card)) {
                        hand.remove(card);
                        roundCards.remove(targetSum - card);
                        coins--;
                        check = true;
                        break;
                    }
                }
            }
            
            // Step3. 손에 있는 카드와 추가 카드 모두로도 해결 불가능한 경우
            if (!check && coins > 1) {
                for (int card : roundCards) {
                    if (roundCards.contains(targetSum - card)) {
                        roundCards.remove(card);
                        roundCards.remove(targetSum - card);
                        coins -= 2;
                        check = true;
                        break;
                    }
                }
            }
            
            // 이 라운드를 완수하지 못했으면 게임 종료
            if (!check) {
                break;
            }
        }
        
        return rounds;
    }
}
