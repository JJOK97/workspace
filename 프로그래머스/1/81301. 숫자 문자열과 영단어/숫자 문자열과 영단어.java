class Solution {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        String answer = s;
        
        // 0부터 9까지의 영단어를 실제 숫자로 변환
        for (int i = 0; i < numbers.length; i++) {
            // numbers[i]를 String.valueOf(i)로 변환
            answer = answer.replace(numbers[i], String.valueOf(i));
        }
        
        return Integer.parseInt(answer);
    }
}