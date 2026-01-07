import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] durability, weight;
    static int maxBroken = 0;

    static void backtrack(int index) {
        if (index == N) {
            int brokenCount = 0;
            for (int i = 0; i < N; i++) {
                if (durability[i] <= 0) {
                    brokenCount++;
                }
            }
            maxBroken = Math.max(maxBroken, brokenCount);
            return;
        }

        if (durability[index] <= 0) {
            backtrack(index + 1);
            return;
        }

        boolean hasHit = false;
        for (int i = 0; i < N; i++) {
            if (i != index && durability[i] > 0) {
                hasHit = true;
                durability[index] -= weight[i];
                durability[i] -= weight[index];

                backtrack(index + 1);

                durability[index] += weight[i];
                durability[i] += weight[index];
            }
        }

        if (!hasHit) {
            backtrack(index + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        durability = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0);
        System.out.print(maxBroken);
    }
}