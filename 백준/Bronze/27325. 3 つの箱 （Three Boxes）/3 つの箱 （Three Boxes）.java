import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cur = 1, ans = 0;
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == 'L') {
        		cur = Math.max(1, cur - 1);
        	}
        	else {
        		cur = Math.min(3, cur + 1);
        	}
        	if (cur == 3) ans++;
        }
        bw.write(ans + "");
        bw.flush();
    }
}