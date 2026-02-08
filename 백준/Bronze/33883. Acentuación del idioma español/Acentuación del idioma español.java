import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String pattern = "nsaeiou", vowel = "aeiou";
        boolean flag = false;
        for (char c : pattern.toCharArray()) {
            if (s.charAt(s.length() - 1) == c) {
                flag = true;
                break;
            }
        }
        int ans = -1;
        if (flag) {
            boolean found = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (char v : vowel.toCharArray()) {
                    if (s.charAt(i) == v) {
                        if (!found)
                            found = true;
                        else {
                            ans = i + 1;
                            break;
                        }
                    }
                }
                if (ans != -1) {
                    break;
                }
            }
        }
        else {
            for (int i = s.length() - 1; i >= 0; i--) {
                for (char v : vowel.toCharArray()) {
                    if (s.charAt(i) == v) {
                        ans = i + 1;
                        break;
                    }
                }
                if (ans != -1) {
                    break;
                }
            }
        }
        System.out.print(ans);
    }
}