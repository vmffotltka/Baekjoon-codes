import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        StringBuilder ans = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == '1') {
        		for (int j = i; j < Math.min(n, i + 3); j++) {
        			ans.setCharAt(j, '1');
        		}
        	}
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
        	if (ans.charAt(i) == '1') cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close(); br.close();
    }
}