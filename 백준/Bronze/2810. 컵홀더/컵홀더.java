import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'S') ans++;
            else if (s.startsWith("LL", i)) {
                ans++;
                i++;
            }
        }
        System.out.print(Math.min(ans + 1, s.length()));
    }
}