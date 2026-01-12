import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String s = br.readLine();
            String a = br.readLine();
            boolean found = true;
            for (char c : a.toCharArray()) {
                if (s.indexOf(c) == -1) {
                    found = false;
                    break;
                }
            }
            sb.append(found ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}