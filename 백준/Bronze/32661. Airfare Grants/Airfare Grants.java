import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int mx = 0, mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }
        System.out.print(Math.max(0, mn - mx / 2));
    }
}