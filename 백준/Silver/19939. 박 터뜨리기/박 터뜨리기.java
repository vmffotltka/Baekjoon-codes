import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int least = k * (k + 1) / 2;
        if (n < least)
            System.out.print(-1);
        else {
            if ((least - n) % k == 0)
                System.out.print(k - 1);
            else
                System.out.print(k);
        }
    }
}