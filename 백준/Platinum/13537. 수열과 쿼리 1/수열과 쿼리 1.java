import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Integer>> tree;

    static int count(List<Integer> li, int k) {
        int s = 0, e = li.size() - 1, pos = li.size();
        while (s <= e) {
            int mid = (s + e) / 2;
            if (li.get(mid) > k) {
                pos = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }
        return li.size() - pos;
    }

    static void init() {
        for (int i = N - 1; i > 0; i--) {
            List<Integer> leftChild = tree.get(i * 2);
            List<Integer> rightChild = tree.get(i * 2 + 1);

            int idx = 0;
            for (int item : leftChild) {
                while (idx < rightChild.size() && item > rightChild.get(idx)) {
                    tree.get(i).add(rightChild.get(idx));
                    idx++;
                }
                tree.get(i).add(item);
            }
            for (int j = idx; j < rightChild.size(); j++) {
                tree.get(i).add(rightChild.get(j));
            }
        }
    }

    static int query(int l, int r, int k) {
        int ans = 0;
        for (l += N - 1, r += N - 1; l <= r; l >>= 1, r >>= 1) {
            if (l % 2 == 1) {
                ans += count(tree.get(l), k);
                l++;
            }
            if (r % 2 == 0) {
                ans += count(tree.get(r), k);
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < N * 2; i++) {
            tree.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree.get(N + i).add(Integer.parseInt(st.nextToken()));
        }
        init();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(query(l, r, k)).append("\n");
        }
        System.out.print(sb);
    }
}