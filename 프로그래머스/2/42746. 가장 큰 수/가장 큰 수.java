import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] number = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            
            number[i] = String.valueOf(numbers[i]);
            
        }
        
        Arrays.sort(number, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            };
        });
            
        if(number[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < number.length; i++){
            sb.append(number[i]);
        }
        
        return sb.toString();
    }
}