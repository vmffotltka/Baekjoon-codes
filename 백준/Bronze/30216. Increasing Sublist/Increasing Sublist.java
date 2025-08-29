import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        int mx = -1;
        for (int i = 0; i < n; i++) {
        	int pre = Integer.parseInt(arr[i]), cnt = 1;
        	for (int j = i + 1; j < n; j++) {
        		int cur = Integer.parseInt(arr[j]);
        		if (pre >= cur) break;
        		
        		cnt++;
        		pre = cur;
        	}
        	mx = Math.max(mx, cnt);
        }
        bw.write(String.valueOf(mx));
        bw.flush();
    }
}