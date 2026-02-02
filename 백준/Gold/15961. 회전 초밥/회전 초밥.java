import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int[] count = new int[d + 1];
        int uniqueCount = 0;
        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) uniqueCount++;
            count[sushi[i]]++;
        }
        int maxUnique = uniqueCount;
        for (int i = 0; i < N; i++) {
            if (count[sushi[i]] == 1) uniqueCount--;
            count[sushi[i]]--;
            int nextSushi = sushi[(i + k) % N];
            if (count[nextSushi] == 0) uniqueCount++;
            count[nextSushi]++;
            int currentUnique = uniqueCount;
            if (count[c] == 0) currentUnique++;
            maxUnique = Math.max(maxUnique, currentUnique);
        }
        System.out.print(maxUnique);
    }
}