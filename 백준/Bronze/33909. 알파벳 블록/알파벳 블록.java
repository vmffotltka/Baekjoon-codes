import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int o = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        System.out.print(Math.min((s + n) / 3, (c + o * 2) / 6));
    }
}