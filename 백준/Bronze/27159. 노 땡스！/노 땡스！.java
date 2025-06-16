import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int pre = 0, ans = 0, mn = 0;
        for (int i = 0; i < n; i++) {
        	int cur = Integer.parseInt(arr[i]);
        	if (cur - pre != 1) {
        		ans += mn;
        		mn = cur;
        	}
        	pre = cur;
        }
        bw.write((ans + mn) + "");
        bw.flush();
        bw.close(); br.close();
    }
}