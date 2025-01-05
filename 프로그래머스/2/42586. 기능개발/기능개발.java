import java.util.*;

class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            // 결과를 담을 ArrayList (배포될 기능의 개수들을 저장)
            ArrayList<Integer> answer = new ArrayList<>();

            // 각 작업이 완료되기까지 필요한 일수를 계산
            int[] daysNeeded = new int[progresses.length];
            for (int i = 0; i < progresses.length; i++) {
                // (100 - 현재진도) / 속도를 계산하고, 올림 처리
                // 예: 진도 93%, 속도 1% => (100-93)/1 = 7일
                daysNeeded[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            }

            // 첫 번째 작업의 배포일을 기준으로 설정
            int deployDay = daysNeeded[0];
            // 현재 배포할 수 있는 기능의 수
            int count = 1;

            // 두 번째 작업부터 순회
            for (int i = 1; i < daysNeeded.length; i++) {
                // 현재 작업의 완료일이 이전 배포일보다 작거나 같으면
                if (daysNeeded[i] <= deployDay) {
                    // 같이 배포할 수 있으므로 카운트 증가
                    count++;
                } else {
                    // 현재 작업의 완료일이 더 크면
                    // 이전까지 카운트한 기능 개수를 배포 목록에 추가
                    answer.add(count);
                    // 새로운 배포일을 현재 작업의 완료일로 설정
                    deployDay = daysNeeded[i];
                    // 카운트를 1로 리셋
                    count = 1;
                }
            }
            // 마지막 묶음의 카운트를 배포 목록에 추가
            answer.add(count);

            // ArrayList를 배열로 변환
            return answer.stream().mapToInt(i -> i).toArray();
        }
}