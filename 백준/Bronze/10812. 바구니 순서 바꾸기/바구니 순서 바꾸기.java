import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) arr[i - 1] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()) - 1;

            ArrayList<Integer> tmp = new ArrayList<>();
            while (tmp.size() < r - l + 1) {
                tmp.add(arr[k]);
                if (k == r - 1) k = l - 1;
                else k++;
            }
            int idx = 0;
            for (int j = l - 1; j < r; j++) {
                arr[j] = tmp.get(idx++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(' ');
        }
        System.out.print(sb);
    }
}