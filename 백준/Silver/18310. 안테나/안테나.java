import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        long[] leftToRight = new long[n], rightToLeft = new long[n];
        for (int i = 1; i < n; i++)
            leftToRight[i] = leftToRight[i - 1] + (long) (arr.get(i) - arr.get(i - 1)) * i;
        for (int i = n - 2; i >= 0; i--)
            rightToLeft[i] = rightToLeft[i + 1] + (long) (arr.get(i + 1) - arr.get(i)) * (n - i - 1);

        long mn = Long.MAX_VALUE, idx = 0;
        for (int i = 0; i < n; i++) {
            if (mn > leftToRight[i] + rightToLeft[i]) {
                mn = leftToRight[i] + rightToLeft[i];
                idx = arr.get(i);
            }
        }
        System.out.print(idx);
    }
}