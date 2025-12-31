import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        int[] cnt = new int['z' - 'a' + 1];
        for (char c : a.toCharArray()) {
            cnt[c - 'a']++;
        }
        String b = br.readLine();
        StringBuilder sb = new StringBuilder(a);
        for (char c : b.toCharArray()) {
            if (--cnt[c - 'a'] < 0) {
                sb.append(c);
            }
        }
        System.out.print(sb);
    }
}