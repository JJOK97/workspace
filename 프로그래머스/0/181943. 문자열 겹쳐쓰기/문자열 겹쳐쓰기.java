import java.util.stream.*;
class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        return IntStream.range(0, my_string.length())
            .mapToObj(i -> 
                      (i >= s && i < s + overwrite_string.length() ? 
                       String.valueOf(overwrite_string.charAt(i-s)) : 
                       String.valueOf(my_string.charAt(i))))
                      .collect(Collectors.joining());
    }
}