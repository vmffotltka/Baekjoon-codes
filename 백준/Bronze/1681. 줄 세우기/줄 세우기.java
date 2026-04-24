import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int ans = 1;
        while (n-- > 0) {
            int num = ans;
            boolean flag = false;
            while (num > 0) {
                if (num % 10 == l) {
                    flag = true;
                    break;
                }
                num /= 10;
            }
            if (flag)
                n++;
            ans++;
        }
        System.out.print(ans - 1);
    }
}