import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i * a <= n; i++) {
            for (int j = 0; i * a + j * b <= n; j++) {
                int remain = n - i * a + j * b;
                if (remain % c == 0) {
                    System.out.print(1);
                    return;
                }
            }
        }
        System.out.print(0);
    }
}