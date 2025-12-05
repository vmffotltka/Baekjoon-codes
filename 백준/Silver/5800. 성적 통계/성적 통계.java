import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int c = 1; c <= t; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(arr);
            int mxGap = -1;
            for (int i = 1; i < n; i++) {
                mxGap = Math.max(mxGap, arr.get(i) - arr.get(i - 1));
            }
            sb.append(String.format("Class %d\nMax %d, Min %d, Largest gap %d\n", c, arr.get(n - 1), arr.get(0), mxGap));
        }
        System.out.print(sb);
    }
}