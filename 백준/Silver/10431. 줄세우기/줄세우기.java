import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cs = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int cnt = 0;
            for (int i = 0; i < 20; i++) {
                int p = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    if (arr[j] > p) {
                        int tmp = arr[j];
                        arr[j] = p;
                        p = tmp;
                        cnt++;
                    }
                }
                arr[i] = p;
            }
            sb.append(cs).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}