import java.io.*;
import java.util.*;

public class Main {

    static boolean dfs(String S, String T) {
        if (S.equals(T)) return true;
        if (T.length() < S.length()) return false;

        if (T.charAt(T.length() - 1) == 'A') {
            if (dfs(S, T.substring(0, T.length() - 1))) return true;
        }
        if (T.charAt(0) == 'B') {
            String reversed = new StringBuilder(T.substring(1)).reverse().toString();
            if (dfs(S, reversed)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.print(dfs(S, T) ? 1 : 0);
    }
}