import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int mn = Integer.MAX_VALUE;
        String eagle = "eagle";
        for (int i = 0; i <= n - 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (s.charAt(i + j) != eagle.charAt(j))
                    cnt++;
            }
            mn = Math.min(mn, cnt);
        }
        System.out.print(mn);
    }
}