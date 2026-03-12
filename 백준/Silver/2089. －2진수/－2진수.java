import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.print(0);
            return;
        }
        StringBuilder s = new StringBuilder().append(n > 0 ? "1" : "");
        long cur = n < 0 ? -2 : 4, sum = n < 0 ? 0 : 1, gap = 0;

        while (n < 0 ? n < sum : n > sum) {
            sum += cur;
            s.append("01");
            cur *= 4;
        }
        gap = Math.abs(n - sum);

        StringBuilder ans = new StringBuilder();
        int pos = 0;
        for (char c : s.toString().toCharArray()) {
            long bit = ((1L << pos) & gap) > 0 ? 1 : 0;
            pos++;
            ans.append((c - '0') ^ bit);
        }
        System.out.print(ans.reverse());
    }
}