import java.util.Scanner;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.print(IntStream.of(n)
                         .filter(num -> num % 2 == 0)
                         .mapToObj(num -> num + " is even")
                         .findFirst() 
                         .orElse(n + " is odd"));
    }
}