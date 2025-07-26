import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int[] cnt = new int[4];
        for (char c : s.toCharArray()) {
        	if (c == 'N') cnt[0]++;
        	else if (c == 'S') cnt[1]++;
        	else if (c == 'W') cnt[2]++;
        	else cnt[3]++;
        }
        bw.write(n - Math.max(Math.max(cnt[0], cnt[1]), Math.max(cnt[2], cnt[3])) + "");
        bw.flush();
    }
}