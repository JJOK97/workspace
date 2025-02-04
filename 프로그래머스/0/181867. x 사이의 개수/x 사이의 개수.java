class Solution {
    public int[] solution(String myString) {
        int[] answer;
        int c = 1;
        
        for(int i = 0; i < myString.length(); i++){
            if(myString.charAt(i) == 'x') {
                c++;
            }
        }
        
        String[] check1 = myString.split("x");
        String[] check2 = new String[c];
        
        for(int i = 0; i < check1.length; i++){
            check2[i] = check1[i];
        }        
        
        for(int i = 0; i < check2.length; i++){
            if(check2[i] == null){
                check2[i] = "";
            }
        }
        
        answer = new int[c];
        
        for(int i = 0; i < c; i++){
            answer[i] = check2[i].length();
        }
        
        return answer;
    }
}