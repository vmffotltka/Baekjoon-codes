import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] ans = new long[n + 2];
        ans[1] = 4;
        ans[2] = 6;
        for (int i = 3; i <= n; i++) {
            ans[i] = ans[i - 2] + ans[i - 1];
        }
        System.out.print(ans[n]);
    }
}