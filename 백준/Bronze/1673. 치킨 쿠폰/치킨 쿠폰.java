import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringBuilder ans = new StringBuilder();
        while ((s = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long sum = 0;
            while (true) {
                sum += (n / k) * k;
                if (n / k > 0)
                    n = n / k + n % k;
                else {
                    sum += n % k;
                    break;
                }
            }
            ans.append(sum).append('\n');
        }
        System.out.print(ans);
    }
}