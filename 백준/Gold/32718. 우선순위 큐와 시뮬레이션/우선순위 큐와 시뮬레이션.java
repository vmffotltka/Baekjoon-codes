import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr.add(Integer.parseInt(st.nextToken()) % k);

        Collections.sort(arr);
        st = new StringTokenizer(br.readLine());
        int a = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            a = (a + Integer.parseInt(st.nextToken())) % k;
            int s = 0, e = n - 1, pos = n - 1;
            while (s <= e) {
                int mid = (s + e) / 2, target = k - a - 1;
                if (arr.get(mid) <= target) {
                    pos = mid;
                    s = mid + 1;
                }
                else e = mid - 1;
            }
            sb.append((arr.get(pos) + a) % k).append(' ');
        }
        System.out.print(sb);
    }
}