import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        double result = Math.pow(2, N);
        
        System.out.println((int) result);
        
    }
}