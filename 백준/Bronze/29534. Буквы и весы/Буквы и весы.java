import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), mx = -1, sum = 0;
        String s = br.readLine();
        for (char c : s.toCharArray()) {
        	int cnt = c - 'a' + 1;
        	mx = Math.max(cnt, mx);
        	sum += cnt;
        }
        bw.write(s.length() > n ? "Impossible" : String.valueOf(sum));
        bw.flush();
	}
}