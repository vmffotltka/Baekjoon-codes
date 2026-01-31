import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] kijun = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            kijun[i] = Integer.parseInt(st.nextToken());
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cookie = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (type == 1) {
                if (arr[0] >= kijun[0] * x &&
                        arr[1] >= kijun[1] * x &&
                        arr[2] >= kijun[2] * x &&
                        arr[3] >= kijun[3] * x) {
                    cookie += x;
                    sb.append(cookie).append("\n");
                    arr[0] -= kijun[0] * x;
                    arr[1] -= kijun[1] * x;
                    arr[2] -= kijun[2] * x;
                    arr[3] -= kijun[3] * x;
                } else {
                    sb.append("Hello, siumii\n");
                }
            }
            else {
                arr[type - 2] += x;
                sb.append(arr[type - 2]).append('\n');
            }
        }
        System.out.print(sb);
    }
}