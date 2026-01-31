import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (n++ < 9999) {
            int a = n / 100, b = n % 100;
            if ((a + b) * (a + b) == n) {
                System.out.print(n);
                return;
            }
        }
        System.out.print(-1);
    }
}