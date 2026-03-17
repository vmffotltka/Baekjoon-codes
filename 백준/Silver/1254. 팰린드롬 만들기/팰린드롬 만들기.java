import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length(), ans = len * 2;
        for (int i = len; i < len * 2; i++) {
            int left = (i - 1) / 2, right = i / 2;
            boolean flag = true;
            while (right < len) {
                if (s.charAt(left) != s.charAt(right)) {
                    flag = false;
                    break;
                }
                right++;
                left--;
            }
            if (flag) {
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}