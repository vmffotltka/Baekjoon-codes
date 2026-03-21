import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++)
            cnt[Integer.parseInt(st.nextToken())]++;
        int ans = 0;
        for (int i = 1; i <= 4; i++) {
            if (cnt[i] == 0) ans++;
        }
        System.out.print(ans);
    }
}