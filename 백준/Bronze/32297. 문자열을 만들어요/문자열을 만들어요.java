import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        boolean ans = false;
        for (int i = 4; i <= n; i++) {
            if (s.substring(i - 4, i).equals("gori"))
                ans = true;
        }
        System.out.print(ans ? "YES" : "NO");
    }
}