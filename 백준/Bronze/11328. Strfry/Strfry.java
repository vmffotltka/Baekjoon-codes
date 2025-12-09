import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken(), b = st.nextToken();

            int[] cnt1 = new int['z' - 'a' + 1], cnt2 = new int['z' - 'a' + 1];
            for (char c : a.toCharArray()) {
                cnt1[c - 'a']++;
            }
            for (char c : b.toCharArray()) {
                cnt2[c - 'a']++;
            }
            boolean ans = true;
            for (int j = 0; j < 'z' - 'a' + 1; j++) {
                if (cnt1[j] != cnt2[j]) {
                    ans = false;
                    break;
                }
            }
            sb.append(ans ? "Possible\n" : "Impossible\n");
        }
        System.out.print(sb);
    }
}