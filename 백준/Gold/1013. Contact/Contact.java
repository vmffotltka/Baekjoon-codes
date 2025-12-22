import java.io.*;
import java.util.*;

public class Main {

    static boolean dfs(String s) {
        if (s.isEmpty())
            return true;
        if (s.startsWith("01"))
            return dfs(s.substring(2));
        if (!s.startsWith("10"))
            return false;

        int idx = 2;
        while (idx < s.length() && s.charAt(idx) == '0') {
            idx++;
        }
        if (idx == 2) return false;

        while (idx < s.length() && s.charAt(idx) == '1') {
            idx++;
            if (dfs(s.substring(idx)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            ans.append(dfs(s) ? "YES\n" : "NO\n");
        }
        System.out.print(ans);
    }
}