import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (p == 0) ans += arr[i];
        }
        System.out.print(sum + "\n" + ans);
    }
}