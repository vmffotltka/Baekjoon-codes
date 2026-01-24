import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % a == 0 && i % b != 0)
                ans++;
            else if (i % b == 0 && i % a != 0)
                ans++;
        }
        System.out.print(ans);
    }
}