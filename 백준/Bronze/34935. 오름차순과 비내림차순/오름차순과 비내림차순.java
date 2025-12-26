import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long prev = Long.parseLong(st.nextToken()), flag = 1;
        for (int i = 1; i < n; i++) {
            long cur = Long.parseLong(st.nextToken());
            if (cur <= prev) {
                flag = 0;
                break;
            }
            prev = cur;
        }
        System.out.print(flag);
    }
}