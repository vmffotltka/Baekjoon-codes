import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] tree;

    static int count(int[] arr, int k) {
        int s = 0, e = arr.length - 1;
        int pos = arr.length;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] > k) {
                pos = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return arr.length - pos;
    }

    static void init() {
        for (int i = N - 1; i > 0; i--) {
            int[] leftChild = tree[i * 2];
            int[] rightChild = tree[i * 2 + 1];

            tree[i] = new int[leftChild.length + rightChild.length];
            int l = 0, r = 0, idx = 0;

            while (l < leftChild.length && r < rightChild.length) {
                if (leftChild[l] < rightChild[r]) {
                    tree[i][idx++] = leftChild[l++];
                } else {
                    tree[i][idx++] = rightChild[r++];
                }
            }
            while (l < leftChild.length) {
                tree[i][idx++] = leftChild[l++];
            }
            while (r < rightChild.length) {
                tree[i][idx++] = rightChild[r++];
            }
        }
    }

    static int query(int l, int r, int k) {
        int ans = 0;
        for (l += N - 1, r += N - 1; l <= r; l >>= 1, r >>= 1) {
            if (l % 2 == 1) {
                ans += count(tree[l], k);
                l++;
            }
            if (r % 2 == 0) {
                ans += count(tree[r], k);
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[2 * N][];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[N + i] = new int[]{ Integer.parseInt(st.nextToken()) };
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