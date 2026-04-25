import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int ALPHABET_SIZE = 'z' - 'a' + 1;
        String plain = br.readLine();
        String key = br.readLine();
        int idx = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            int c = key.charAt(idx++) - 'a';
            if (idx == key.length())
                idx = 0;

            if (plain.charAt(i) == ' ') {
                ans.append(' ');
                continue;
            }
            int p = plain.charAt(i) - 'a';
            p = (p + ALPHABET_SIZE - c - 1) % ALPHABET_SIZE;
            ans.append((char)(p + 'a'));
        }
        System.out.print(ans);
    }
}