import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        System.out.print(Math.max(0, 10 + 2 * (25 - a + t)));
    }
}