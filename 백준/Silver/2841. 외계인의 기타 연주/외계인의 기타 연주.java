import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        List<Stack<Integer>> stack = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            stack.add(new Stack<>());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int note = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());

            while (!stack.get(note).empty() && stack.get(note).peek() > flat) {
                stack.get(note).pop();
                ans++;
            }

            if (stack.get(note).empty() || stack.get(note).peek() != flat) {
                stack.get(note).push(flat);
                ans++;
            }
        }
        System.out.print(ans);
    }
}