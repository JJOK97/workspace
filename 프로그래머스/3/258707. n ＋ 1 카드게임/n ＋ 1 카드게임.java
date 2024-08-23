import java.util.*;

class Solution {
    public int solution(int coins, int[] cards) {
        Set<Integer> curr = new HashSet<>();
        Set<Integer> newCard = new HashSet<>();

        int idx = 0;
        for (; idx < cards.length / 3; idx++) {
            curr.add(cards[idx]);
        }

        int rounds = 1;
        int target = cards.length + 1;

        while (idx < cards.length) {
            // 두장 드로우
            newCard.add(cards[idx++]);
            newCard.add(cards[idx++]);

            boolean check = false;
            int first = -1, second = -1;

            // 현재 손에 있는 카드들에서 목표 합을 이루는 쌍을 찾음
            for (int card : curr) {
                if (curr.contains(target - card)) {
                    check = true;
                    first = card;
                    second = target - card;
                    break;
                }
            }

            // 현재 손에 있는 카드들만으로 쌍을 찾지 못한 경우
            if (!check && coins > 0) {
                for (int card : curr) {
                    
                    int another = target - card;
                    
                    if (newCard.contains(another)) {
                        coins--;
                        check = true;
                        first = card;
                        second = another;
                        break;
                    }
                }
            }

            // 추가 카드들끼리 조합해 쌍을 찾는 경우
            // 한 카드씩 체크해본 후에 두 카드를 확인해야함
            if (!check && coins > 1) {
                for (int card : newCard) {
                    int another = target - card;

                    if (newCard.contains(another)) {
                        coins -= 2;
                        check = true;
                        first = card;
                        second = another;
                        break;
                    }
                }
            }

            // 만약 쌍을 찾지 못했다면 게임 종료
            if (!check) {
                break;
            } else {
                newCard.remove(first);
                newCard.remove(second);
                curr.remove(first);
                curr.remove(second);
            }

            rounds++;
        }

        return rounds;
    }
}
