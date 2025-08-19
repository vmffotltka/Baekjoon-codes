import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        int ans = 0, streak = 0;
        for (int i = 0; i < n; i++) {
        	if (Integer.parseInt(input[i]) == 0) {
        		streak = 0;
        	}
        	else {
        		streak++;
        		ans = Math.max(ans, streak);
        	}
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}