import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long cluster = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());
            ans += cluster * ((num + cluster - 1) / cluster);
        }
        System.out.print(ans);
    }
}