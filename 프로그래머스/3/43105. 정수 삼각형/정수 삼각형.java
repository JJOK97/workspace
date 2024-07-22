class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        
        for(int i = triangle.length - 2; i >= 0; i--){
            for(int j = 0; j < triangle[i].length; j++){
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j + 1]);
            }
        }
        
        answer = triangle[0][0];
        return answer;
    }
}