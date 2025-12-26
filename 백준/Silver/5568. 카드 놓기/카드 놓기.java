import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] numbers;
    static boolean[] vis;
    static Set<Integer> set = new HashSet<>();
    static void dfs(int count, StringBuilder sb) {
        if (count == K) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            dfs(count + 1, new StringBuilder(sb.toString()).append(numbers[i]));
            vis[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        numbers = new int[N];
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, new StringBuilder());
        System.out.print(set.size());
    }
}