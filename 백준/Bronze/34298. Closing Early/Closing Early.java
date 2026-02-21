import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int ans = -1, sum = 0;
        if (r == 0) {
            System.out.print(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            if (sum % s == r) {
                ans = i + 1;
                break;
            }
            sum %= s;
        }
        System.out.print(ans);
    }
}