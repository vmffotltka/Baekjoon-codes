import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);
        
        input = br.readLine().split(" ");
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	int cnt = 0;
        	for (int j = 0; j < k; j++) {
            	int cur = Integer.parseInt(input[i * k + j]);
        		if (cur == 0) cnt++;
        	}
        	if (cnt < p) ans++;
        }
        bw.write(ans + "");
        bw.flush();
    }
}