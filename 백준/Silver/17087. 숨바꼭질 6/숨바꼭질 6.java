import java.io.*;
import java.util.*;

public class Main {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        arr.add(s);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        int ans = arr.get(1) - arr.get(0);
        for (int i = 2; i < n + 1; i++) {
            ans = gcd(ans, arr.get(i) - arr.get(i - 1));
        }
        System.out.print(ans);
    }
}