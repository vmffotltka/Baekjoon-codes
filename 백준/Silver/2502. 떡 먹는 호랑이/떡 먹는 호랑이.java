import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a1 = 1, a2 = 0, b1 = 0, b2 = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 2; i < day; i++) {
            int a = a1 + a2, b = b1 + b2;
            a1 = a2; a2 = a;
            b1 = b2; b2 = b;
        }
        for (int i = 1; k - i * a2 >= 0; i++) {
            if ((k - i * a2) % b2 == 0) {
                System.out.println(i);
                System.out.print((k - i * a2) / b2);
                break;
            }
        }
    }
}