import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String front = st.nextToken(), back = st.nextToken();

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            if (s.startsWith(front) && s.endsWith(back) && s.length() >= front.length() + back.length())
                sb.append("DA\n");
            else
                sb.append("NE\n");
        }
        System.out.print(sb);
    }
}