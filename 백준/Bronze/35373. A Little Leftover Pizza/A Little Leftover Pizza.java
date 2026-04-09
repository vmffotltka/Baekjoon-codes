import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char size = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if (size == 'S') cnt[0] += num;
            else if (size == 'M') cnt[1] += num;
            else cnt[2] += num;
        }
        int ans = (cnt[0] + 5) / 6 + (cnt[1] + 7) / 8 + (cnt[2] + 11) / 12;
        System.out.print(ans);
    }
}