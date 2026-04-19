import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean odd = false;
        int sum = 0;
        for (int i = 0 ; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            sum += x;
            if (x % 2 == 1) odd = true;
        }
        if (sum % 2 == 0 || (sum % 2 == 1 && odd && n > 1))
            System.out.print("YES");
        else
            System.out.print("NO");
    }
}