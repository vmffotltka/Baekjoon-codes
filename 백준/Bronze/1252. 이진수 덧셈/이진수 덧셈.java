import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        StringBuilder sb = new StringBuilder();
        int up = 0, idx1 = s1.length() - 1, idx2 = s2.length() - 1;
        while (true) {
            if (idx1 < 0 && idx2 < 0 && up == 0) break;
            int digit1 = (idx1 < 0 ? 0 : s1.charAt(idx1--) - '0');
            int digit2 = (idx2 < 0 ? 0 : s2.charAt(idx2--) - '0');
            int sum = digit1 + digit2 + up;
            sb.append(sum % 2);
            up = sum / 2;
        }
        int idx = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                idx = i;
                break;
            }
        }
        System.out.print(sb.reverse().substring(sb.length() - idx - 1));
    }
}