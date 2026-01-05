import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(-num);
            }
        }
        pos.sort(Collections.reverseOrder());
        neg.sort(Collections.reverseOrder());

        int ans = 0, idx1 = 0, idx2 = 0;
        if ((neg.isEmpty() ? -1 : neg.get(0)) >= (pos.isEmpty() ? -1 : pos.get(0))) {
            ans += neg.get(0);
            idx2 = m;
        }
        else {
            ans += pos.get(0);
            idx1 = m;
        }
        while (idx1 < pos.size() || idx2 < neg.size()) {
            if (idx1 < pos.size()) {
                ans += 2 * pos.get(idx1);
                idx1 += m;
            }
            if (idx2 < neg.size()) {
                ans += 2 * neg.get(idx2);
                idx2 += m;
            }
        }
        System.out.print(ans);
    }
}