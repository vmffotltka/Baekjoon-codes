import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	int ans = 0;
        	for (char c : s.toCharArray()) {
        		if (c == 'I') ans++;
        		else if (c == 'V') ans += 5;
        		else if (c == 'X') ans += 10;
        		else if (c == 'L') ans += 50;
        		else if (c == 'C') ans += 100;
        		else if (c == 'D') ans += 500;
        		else if (c == 'M') ans += 1000;
        	}
        	bw.write(ans + "\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}