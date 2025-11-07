import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long d = Long.parseLong(br.readLine());
        
        long len = x * 100 + y;
        long a = (len - 2 * d) / 4;
        long b = a + d;
        
        System.out.printf("%d %d\n%d %d", b / 100, b % 100, a / 100, a % 100);
    }
}