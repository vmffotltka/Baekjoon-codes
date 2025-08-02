import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long sum = 0, cur = 30, cnt = 0;
        for (int i = 0; i < n; i++) {
        	sum += cur;
        	if (cnt == 4) {
        		cur += 30;
        		cnt = 0;
        	}
        	else cnt++;
        }
        bw.write(sum + "");
        bw.flush();
    }
}