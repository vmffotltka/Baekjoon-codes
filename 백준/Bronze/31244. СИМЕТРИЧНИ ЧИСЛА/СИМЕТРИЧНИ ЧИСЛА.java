import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder().append(a).append(b).append(c);
        if (b == c && a != b) sb.append(a);
        else if (b != c && a != c) sb.append(b).append(a);
        System.out.print(sb);
    }
}