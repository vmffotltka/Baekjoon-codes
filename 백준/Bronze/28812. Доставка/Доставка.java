import java.io.*;
import java.util.*;

public class Main {
	
	
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        
        int mn = INF;
        for (int i = 0; i < n; i++) {
        	input = br.readLine().split(" ");
        	int p = Integer.parseInt(input[0]);
        	int d = Integer.parseInt(input[1]);
        	int v = Integer.parseInt(input[2]);
        	mn = Math.min(mn, p + d + v * c);
        }
        bw.write(String.valueOf(mn));
        bw.flush();
    }
}