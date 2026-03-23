import java.io.*;
import java.util.*;

public class Main {

    static int[] mx, mn, left, right;
    static int solve(int node, int depth, int coor) {
        if (node == -1) return 0;
        int child = solve(left[node], depth + 1, coor);
        mx[depth] = Math.max(mx[depth], child + coor + 1);
        mn[depth] = Math.min(mn[depth], child + coor + 1);

        child += solve(right[node], depth + 1, coor + child + 1);
        return child + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        mx = new int[n + 1];
        mn = new int[n + 1];
        for (int i = 1; i <= n; i++)
            mn[i] = Integer.MAX_VALUE;

        left = new int[n + 1];
        right = new int[n + 1];

        boolean[] hasParent = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            left[num] = l;
            right[num] = r;
            if (l != -1)
                hasParent[l] = true;
            if (r != -1)
                hasParent[r] = true;
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (!hasParent[i]) {
                root = i;
                break;
            }
        }
        solve(root, 1, 0);
        int mxWidth = 0, level = 0;
        for (int i = 1; i <= n; i++) {
            if (mn[i] == Integer.MAX_VALUE) break;
            if (mx[i] - mn[i] + 1 > mxWidth) {
                mxWidth = mx[i] - mn[i] + 1;
                level = i;
            }
        }
        System.out.print(level + " " + mxWidth);
    }
}