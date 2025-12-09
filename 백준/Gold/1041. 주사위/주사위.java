import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] index = { "012", "013", "034", "024", "512", "513", "534", "524" };
        long n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] num = new long[6];
        for (int i = 0; i < 6; i++) { num[i] = Long.parseLong(st.nextToken()); }

        if (n == 1) {
            ArrayList<Long> arr = new ArrayList<>();
            long sum = 0;
            for (int i = 0; i < 6; i++) {
                arr.add(num[i]);
                sum += num[i];
            }

            Collections.sort(arr);

            System.out.print(sum - arr.get(arr.size() - 1));
            return;
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < index.length; i++) {
            ArrayList<Long> arr = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                arr.add(num[index[i].charAt(j) - '0']);
            }
            Collections.sort(arr);

            long sum = 0;
            sum += arr.get(0) * ((n - 2) * (n - 2) + (n - 2) * (n - 1) * 4);
            sum += (arr.get(0) + arr.get(1)) * ((n - 1) * 4 + (n - 2) * 4);
            sum += (arr.get(0) + arr.get(1) + arr.get(2)) * 4;
            ans = Math.min(ans, sum);
        }
        System.out.print(ans);
    }
}