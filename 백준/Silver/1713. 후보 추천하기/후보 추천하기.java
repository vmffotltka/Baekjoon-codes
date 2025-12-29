import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[101];

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (Integer integer : arr) {
                if (integer == x) {
                    cnt[x]++;
                    flag = true;
                    break;
                }
            }
            if (flag) continue;

            if (arr.size() == n) {
                int min = Integer.MAX_VALUE, idx = -1;
                for (int j = 0; j < arr.size(); j++) {
                    if (cnt[arr.get(j)] < min) {
                        min = cnt[arr.get(j)];
                        idx = j;
                    }
                }
                cnt[arr.get(idx)] = 0;
                arr.remove(idx);
            }
            arr.add(x);
        }
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : arr) {
            sb.append(integer).append(" ");
        }
        System.out.print(sb);
    }
}