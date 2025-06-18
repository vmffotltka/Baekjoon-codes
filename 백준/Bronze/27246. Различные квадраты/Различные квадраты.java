import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine()), w = 1, ans = 0;
        while (true) {
        	if (n < w * w) break;
        	n -= w * w;
        	w++; ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}