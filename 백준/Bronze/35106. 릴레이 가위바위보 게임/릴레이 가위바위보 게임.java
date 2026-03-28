import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[4];
        for (int i = 0; i < n * 3; i++) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }
        int more = -1, less = -1;
        for (int i = 1; i <= 3; i++) {
            if (cnt[i] == n + 1) more = i;
            else if (cnt[i] == n - 1) less = i;
        }
        System.out.println(less);
        System.out.print(more);
    }
}