class Solution {
    private static final int[][] KEYPAD = {
        {3,1},
        {0,0},
        {0,1},
        {0,2},
        {1,0},
        {1,1},
        {1,2},
        {2,0},
        {2,1},
        {2,2},
    };
    
    private int getDistance(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] leftPos = {3,0};
        int[] rightPos = {3,2};
        boolean isRightHanded = hand.equals("right");
        
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = KEYPAD[num];
            }
            else if(num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = KEYPAD[num];
            }
            else {
                int[] numPos = KEYPAD[num];
                int leftDist = getDistance(leftPos, numPos);
                int rightDist = getDistance(rightPos, numPos);
                
                if(leftDist < rightDist) {
                    answer.append("L");
                    leftPos = numPos;
                }
                else if(leftDist > rightDist) {
                    answer.append("R");
                    rightPos = numPos;
                }
                else {
                    if(isRightHanded) {
                        answer.append("R");
                        rightPos = numPos;
                    } else {
                        answer.append("L");
                        leftPos = numPos;
                    }
                }
            }
        }
        
        return answer.toString();
    }
}