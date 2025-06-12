import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int pre = Integer.parseInt(input[0]), ans = 0;
        for (int i = 1; i < n; i++) {
        	int cur = Integer.parseInt(input[i]);
        	if (pre < cur) ans++;
        	pre = cur;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}