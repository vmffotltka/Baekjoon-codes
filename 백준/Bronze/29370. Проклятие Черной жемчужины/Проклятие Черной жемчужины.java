import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static final int MAX = 'z' - 'a' + 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long ans = 0;
        String s = br.readLine();
        int l = 0, r = 0;
        int[] cnt = new int[MAX];
        int characters = 0;
        while (r < s.length()) {
            while (r < s.length()) {
                int c = s.charAt(r) == '?' ? MAX - 1 : s.charAt(r) - 'a';
                if (cnt[c]++ == 0 && c != MAX - 1)
                    characters++;
                if (characters > 1) {
                    cnt[c]--;
                    characters--;
                    break;
                }
                ans += r - l + 1;
                r++;
            }
            while (l < r && characters >= 1) {
                int c = s.charAt(l) == '?' ? MAX - 1 : s.charAt(l) - 'a';
                if (--cnt[c] == 0 && c != MAX - 1)
                    characters--;
                l++;
            }
        }
        System.out.print(ans);
    }
}