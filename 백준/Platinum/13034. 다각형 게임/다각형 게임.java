import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] g = new int[n + 1];

        g[0] = 0;
        g[1] = 0;
        for (int i = 2; i <= n; i++) {
            Set<Integer> set = new HashSet<>();

            for (int k = 0; k <= i - 2; k++) {
                int val = g[k] ^ g[i - 2 - k];
                set.add(val);
            }

            int mex = 0;
            while (set.contains(mex)) {
                mex++;
            }
            g[i] = mex;
        }
        if (g[n] > 0)
            System.out.print(1);
        else
            System.out.print(2);
    }
}