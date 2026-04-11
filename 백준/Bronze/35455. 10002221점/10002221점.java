import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long note = Long.parseLong(st.nextToken());
            long score = Long.parseLong(st.nextToken());
            if (score == 10000000 + note)
                sb.append("Yes\n");
            else
                sb.append("No\n");
        }
        System.out.print(sb);
    }
}