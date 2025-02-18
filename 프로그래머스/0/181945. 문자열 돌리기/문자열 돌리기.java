import java.util.Scanner;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        System.out.println(printY(a));
        
    }
    
    public static String printY(String s){
        return IntStream.range(0, s.length())
            .mapToObj(i -> String.valueOf(s.charAt(i)))
            .collect(Collectors.joining("\n"));
    }
}