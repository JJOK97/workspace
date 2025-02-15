import java.util.*;

class Solution {
    
    class WordStep {
        String word;
        int step;
        
        WordStep(String word, int step){
            this.word = word;
            this.step = step;
        }
    }
    
    public int solution (String begin, String target, String[] words){
        
        boolean exists = false;
        for (String word : words){
            if(word.equals(target)){
                exists = true;
                break;
            }
        }
        
        if(!exists) return 0;
        
        Queue<WordStep> queue = new LinkedList<>();
        queue.offer(new WordStep(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()){
            
            WordStep current = queue.poll();
            
            if(current.word.equals(target)) return current.step;
            
            for(int i = 0; i < words.length; i++){
                if(!visited[i] && isOneLetterDiff(current.word, words[i])) {
                    visited[i] = true;
                    queue.offer(new WordStep(words[i], current.step + 1));
                }
            }
            
        }
        
        return 0;
        
    }
    
    private boolean isOneLetterDiff(String s1, String s2){
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++)
            if(s1.charAt(i) != s2.charAt(i)) diffCount++;

        return diffCount == 1;
    }
    
}