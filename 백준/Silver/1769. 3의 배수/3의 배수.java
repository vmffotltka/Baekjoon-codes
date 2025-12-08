import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());
        int sum = 0, cnt = 0;
        while (true) {
            sum = 0;
            for (char c : sb.toString().toCharArray()) {
                sum += c - '0';
            }
            StringBuilder next = new StringBuilder();
            if (sb.length() <= 1) break;
            cnt++;
            while (sum > 0) {
                next.append(sum % 10);
                sum /= 10;
            }
            sb = next;
        }
        System.out.println(cnt);
        System.out.print(sum % 3 == 0 ? "YES" : "NO");
    }
}