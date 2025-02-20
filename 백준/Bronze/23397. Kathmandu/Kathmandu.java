import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);
        int mx = 0, pre = 0;
        for (int i = 0; i < m; i++) {
        	int p = Integer.parseInt(br.readLine());
        	if (i == 0) mx = p;
        	else mx = Math.max(mx, p - pre);
        	pre = p;
        }
        mx = Math.max(mx, d - pre);
        bw.write(mx >= t ? "Y" : "N");
        bw.flush();
        bw.close(); br.close();
	}
}