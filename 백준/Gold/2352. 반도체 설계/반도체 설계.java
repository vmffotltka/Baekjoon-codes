import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if (arr.isEmpty() || arr.get(arr.size() - 1) < p) {
                arr.add(p);
            } else {
                int idx = Collections.binarySearch(arr, p);
                if (idx < 0)
                    idx = -(idx + 1);
                arr.set(idx, p);
            }
        }
        System.out.print(arr.size());
    }
}