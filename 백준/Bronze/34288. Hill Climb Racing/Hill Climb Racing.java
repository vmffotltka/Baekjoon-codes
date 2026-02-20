import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int pre = 0;
        for (int i = 0; i <= l; i++) {
            int height = Integer.parseInt(st.nextToken());
            if (height - pre > a) {
                System.out.print("BUG REPORT");
                return;
            }
            pre = height;
        }
        System.out.print("POSSIBLE");
    }
}