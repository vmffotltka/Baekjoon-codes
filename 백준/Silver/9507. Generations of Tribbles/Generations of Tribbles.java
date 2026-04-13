import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static int MAX = 68;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] koong = new long[MAX];
        koong[0] = 1; koong[1] = 1; koong[2] = 2; koong[3] = 4;
        for (int i = 4; i < MAX; i++)
            koong[i] = koong[i - 1] + koong[i - 2] + koong[i - 3] + koong[i - 4];

        int n = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            ans.append(koong[num]).append('\n');
        }
        System.out.print(ans);
    }
}