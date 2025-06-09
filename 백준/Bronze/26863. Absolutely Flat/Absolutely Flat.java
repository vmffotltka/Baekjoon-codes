import java.io.*;
import java.util.*;

public class Main {
	static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int mn = INF, mx = -INF;
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	mn = Math.min(mn, arr[i]);
        	mx = Math.max(mx, arr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
        	if (mn == arr[i]) cnt++;
        }
        int pad = Integer.parseInt(br.readLine());
        bw.write(cnt == 4 || (cnt == 1 && mn + pad == mx) ? "1" : "0");
        
        bw.flush();
        bw.close(); br.close();
    }
}