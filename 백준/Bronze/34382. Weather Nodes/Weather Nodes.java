import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double sum = 0;
        Double[] arr = new Double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
            sum += arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] * n - 10 * n <= sum && arr[i] * n + 10 * n >= sum)
                continue;
            ans++;
        }
        System.out.print(ans);
    }
}