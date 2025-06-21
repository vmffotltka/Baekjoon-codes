import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int cs = 1; cs <= t; cs++) {
        	int ans = 0, n = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n; i++) {
        		if (st.nextToken().equals("sheep")) ans++;
        	}
        	bw.write(String.format("Case %d: This list contains %d sheep.\n\n", cs, ans));
        }
        bw.flush();
    }
}