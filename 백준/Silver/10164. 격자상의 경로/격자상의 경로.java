import java.io.*;
import java.util.*;

public class Main {

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sero = Math.max(0, (k - 1)) / m, garo = Math.max(0, (k - 1)) % m;
        long way1 = factorial(sero + garo) / (factorial(sero) * factorial(garo));
        long way2 = factorial((n - 1 - sero) + (m - 1 - garo)) / (factorial(n - 1 - sero) * factorial(m - 1 - garo));
        System.out.print(way1 * way2);
    }
}