import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            String inOrOut = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (inOrOut.equals("IN")) ans += num;
            else ans -= num;
        }
        if (ans == 0) System.out.print("NO STRAGGLERS");
        else System.out.print(ans);
    }
}