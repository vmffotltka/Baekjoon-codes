import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] index = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < n * 2; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (index[num] == 0)
                index[num] = i + 1;
            else
                ans = Math.max(ans, i - index[num]);
        }
        System.out.print(ans);
    }
}