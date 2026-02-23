import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int pre = h * 3600 + m * 60 + s;

        st = new StringTokenizer(br.readLine(), ":");
        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int cur = h2 * 3600 + m2 * 60 + s2;

        int hCount = 0, mCount = 0, sCount = 0;
        for (int i = pre + 1; i <= cur; i++) {
            if (i % 60 == 0) sCount++;
            if (i % 3600 == 0) mCount++;
            if (i % 43200 == 0) hCount++;
        }
        System.out.print(hCount + " " + mCount + " " + sCount);
    }
}