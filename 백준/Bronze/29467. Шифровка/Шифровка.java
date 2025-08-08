import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine(), mx = "";
        for (int i = 0; i < s.length(); i++) {
        	for (int j = i + 1; j <= s.length(); j++) {
        		String sb = s.substring(i, j);
        		if (sb.compareTo(mx) > 0) {
        			mx = sb;
        		}
        	}
        }
        bw.write(mx);
        bw.flush();
	}
}