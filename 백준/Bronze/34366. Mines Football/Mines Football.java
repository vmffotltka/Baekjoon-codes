import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> li = new ArrayList<>();
        int mx = -1, mn = Integer.MAX_VALUE, mxSum = 0, mnSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            int len = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                mx = Math.max(mx, num);
                mn = Math.min(mn, num);
                sum += num;
                list.add(num);
            }
            li.add(list);
            if (sum > mxSum)
                mxSum = sum;
            if (sum < mnSum)
                mnSum = sum;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(mx).append("\n").append(mn).append("\n").append(mxSum).append("\n").append(mnSum);
        System.out.print(sb);
    }
}