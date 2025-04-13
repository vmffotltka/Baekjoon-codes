import java.io.*;
import java.util.*;

public class Main {
	static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int mn = INF, ans = 0;
        for (int cnt = 9999; cnt >= 99; cnt -= 100) {
        	if (Math.abs(n - cnt) < mn) {
        		mn = Math.abs(n - cnt);
        		ans = cnt;
        	}
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}