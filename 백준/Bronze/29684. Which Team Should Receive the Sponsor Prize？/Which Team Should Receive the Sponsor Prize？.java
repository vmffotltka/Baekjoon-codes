import java.io.*;
import java.util.*;

public class Main {
	
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
        	int n = Integer.parseInt(br.readLine());
        	if (n == 0) break;
        	
        	String[] input = br.readLine().split(" ");
        	
        	int mn = INF, idx = 0;
        	for (int i = 0; i < n; i++) {
        		int p = Integer.parseInt(input[i]);
        		if (mn > Math.abs(p - 2023)) {
        			mn = Math.abs(p - 2023);
        			idx = i + 1;
        		}
        	}
        	bw.write(idx + "\n");
        }
        
        bw.flush();
    }
}