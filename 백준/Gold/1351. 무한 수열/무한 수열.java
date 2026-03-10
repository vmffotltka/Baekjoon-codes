import java.io.*;
import java.util.*;

public class Main {

    static Map<Long, Long> memo = new HashMap<>();
    static long solve(long n, long p, long q) {
        if (n == 0) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        long result = solve(n / p, p, q) + solve(n / q, p, q);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        System.out.print(solve(n, p, q));
    }
}