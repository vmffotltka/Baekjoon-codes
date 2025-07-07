import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int ans = 1;
        for (int i = 1; i < n; i++) {
        	int pre = Integer.parseInt(input[i - 1]);
        	int cur = Integer.parseInt(input[i]);
        	if (pre <= cur) ans++;
        }
        bw.write(ans + "");
        bw.flush();
    }
}