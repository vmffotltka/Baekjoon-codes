import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            int cnt = 0;
            for (int i = 3; i <= s.length(); i++) {
                if (s.startsWith("WOW", i - 3)) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}