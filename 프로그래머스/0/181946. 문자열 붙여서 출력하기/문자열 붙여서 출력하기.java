import java.util.Scanner;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        String result = Stream.concat(
            a.chars().mapToObj(c -> (char) c),
            b.chars().mapToObj(c -> (char) c))
            .map(String::valueOf).collect(Collectors.joining());
        
        System.out.println(result);
        
        
    }
}