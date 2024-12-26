class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        
        if( arr.length - 1 == 0){
            return new int[]{-1};
        } else {
            answer = new int[arr.length - 1];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++) {
            min = min > arr[i] ? arr[i] : min;
        }
        
        int index = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != min){
                answer[index++] = arr[i];
            } else {
                continue;
            }
        }
        
        return answer;
    }
}