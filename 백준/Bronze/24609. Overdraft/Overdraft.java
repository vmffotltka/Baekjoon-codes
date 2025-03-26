import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cur = 0, ans = 0;
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(br.readLine());
        	if (cur + p < 0) ans = Math.max(ans, Math.abs(cur + p));
        	cur += p;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}