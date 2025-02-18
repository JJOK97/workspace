import java.util.Scanner;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        System.out.println(swapCase(a));
        
    }
    
    public static String swapCase(String str){
        
        return str.chars()
            .mapToObj(c -> Character.isUpperCase(c) ?
                     Character.toLowerCase((char) c) :
                     Character.toUpperCase((char) c))
            .map(String::valueOf)
            .collect(Collectors.joining());
        
    }
}