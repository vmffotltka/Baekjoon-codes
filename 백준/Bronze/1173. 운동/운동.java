import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int cur = m, time = 0, exercise = 0;
        if (M - m < T) {
            System.out.print(-1);
            return;
        }
        while (true) {
            while (cur + T <= M) {
                cur += T;
                time++;
                exercise++;
                if (exercise == N) break;
            }
            if (exercise == N) break;
            cur = Math.max(m, cur - R);
            time++;
        }
        System.out.print(time);
    }
}