import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new int[]{ a, b });
        }
        arr.sort((o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int p = arr.get(i)[0], d = arr.get(i)[1];
            while (!pq.isEmpty() && pq.size() >= d)
                pq.poll();
            pq.add(p);
        }
        int ans = 0;
        while (!pq.isEmpty())
            ans += pq.poll();
        System.out.print(ans);
    }
}