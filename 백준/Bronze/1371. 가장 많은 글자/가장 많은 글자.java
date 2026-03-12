import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        int[] cnt = new int[26];
        while ((s = br.readLine()) != null) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    cnt[c - 'a']++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int mx = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > mx) {
                mx = cnt[i];
                sb.setLength(0);
                sb.append((char) (i + 'a'));
            }
            else if (cnt[i] == mx) {
                sb.append((char) (i + 'a'));
            }
        }
        System.out.print(sb);
    }
}