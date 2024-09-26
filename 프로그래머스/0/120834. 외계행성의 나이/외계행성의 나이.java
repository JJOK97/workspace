class Solution {
    public String solution(int age) {
        String answer = "";
        
        char[] alph = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        
        StringBuilder sb = new StringBuilder(answer);
        
        boolean[] check = new boolean[4];
        
        int N = 0;
        
        N = age/1000;
        
        if(N != 0){
            sb.append(alph[N]);
            check[3] = true;
        } 
        
        N = age%1000;
        N = N / 100;
        
        if(N != 0 || check[3]){
            sb.append(alph[N]);
            check[2] = true;
        } 
        
        N = age%100;
        N = N / 10;
        
        if(N != 0 || check[2] ){
            sb.append(alph[N]);
            check[1] = true;
        } 
        
        N = age%10;
        N = N / 1;
        
        if(N != 0 || check[1]){
            sb.append(alph[N]);
        } 
        
        answer = sb.toString();
        
        return answer;
    }
}