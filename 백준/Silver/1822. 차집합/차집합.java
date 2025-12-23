import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!set.contains(arr.get(i))) {
                ans++;
                sb.append(arr.get(i)).append(' ');
            }
        }

        System.out.println(ans);
        System.out.print(sb);
    }
}