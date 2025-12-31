import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double mx = 1, ans = -1;
        for (int i = 0; i < n; i++) {
            double x = Double.parseDouble(br.readLine());
            mx = Math.max(x, mx * x);
            ans = Math.max(ans, mx);
        }
        System.out.printf("%.3f", ans);
    }
}