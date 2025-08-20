import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        char pre = 0;
        int ren = 1, ans = 0;
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == pre) {
        		ren++;
        	}
        	else {
        		ans += (pre == 'a' && ren > 1 ? ren : 0);
        		ren = 1;
        	}
        	pre = s.charAt(i);
        }
		ans += (pre == 'a' && ren > 1 ? ren : 0);
		
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}