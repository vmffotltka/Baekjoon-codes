import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int MAX = (int)Math.pow(2, N) - 1;
        arr = new int[MAX];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < MAX; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = MAX / 2, gap = MAX + 1;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            for (int i = start; i < MAX; i += gap)
                sb.append(arr[i]).append(" ");
            sb.append('\n');
            start >>= 1;
            gap >>= 1;
        }
        System.out.print(sb);
    }
}