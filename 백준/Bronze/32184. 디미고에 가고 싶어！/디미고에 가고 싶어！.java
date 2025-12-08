import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = (a % 2 == 0 ? 1 : 0) + (b % 2 == 1 ? 1 : 0);
        if (a % 2 == 0) a++;
        if (b % 2 == 1) b--;
        System.out.print(ans + (b - a + 1) / 2);
    }
}