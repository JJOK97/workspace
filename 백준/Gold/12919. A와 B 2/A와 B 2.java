import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String A;
    static String B;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        size = B.length();

        boolean result = cal(B);

        System.out.println(result ? 1 : 0);
    }

    public static boolean cal(String current) {
        if (current.length() == A.length()) {
            if (current.equals(A)) {
                return true;
            }
            return false;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            if (cal(current.substring(0, current.length() - 1))) {
                return true;
            }
        }
        
        if (current.charAt(0) == 'B') {
            String substring = current.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String reversed = sb.reverse().toString();
            if (cal(reversed)) {
                return true;
            }
        }

        return false;
    }
}