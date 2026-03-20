import java.io.*;
import java.util.*;

public class Main {

    static int ans = -1;
    static int N;
    static void solve(int n) {
        if (N < n) return;
        ans = Math.max(n, ans);
        solve(n * 10 + 4);
        solve(n * 10 + 7);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        solve(0);
        System.out.print(ans);
    }
}