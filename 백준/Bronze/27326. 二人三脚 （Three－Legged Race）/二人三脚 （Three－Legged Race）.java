import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n * 2 - 1; i++) {
        	int p = Integer.parseInt(input[i]);
        	cnt[p]++;
        }
        for (int i = 1; i <= n; i++) {
        	if (cnt[i] == 1) bw.write(i + "");
        }
        bw.flush();
    }
}