import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }
        arr.sort(Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 2) continue;
            ans += arr.get(i);
        }
        System.out.print(ans);
    }
}