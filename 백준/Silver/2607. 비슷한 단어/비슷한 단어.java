import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int similarCount = 0;
        String s = br.readLine();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < n - 1; i++) {
            String s2 = br.readLine();
            if (Math.abs(s.length() - s2.length()) > 1) continue;

            int[] cnt2 = new int[26];
            for (int j = 0; j < s2.length(); j++) {
                cnt2[s2.charAt(j) - 'A']++;
            }
            int sameCount = 0;
            for (int j = 0; j < 26; j++) {
                sameCount += Math.min(cnt[j], cnt2[j]);
            }
            if (s.length() == s2.length() && sameCount >= s.length() - 1)
                similarCount++;
            else if (s.length() + 1 == s2.length() && sameCount == s.length())
                similarCount++;
            else if (s.length() == s2.length() + 1 && sameCount == s2.length())
                similarCount++;
        }
        System.out.print(similarCount);
    }
}