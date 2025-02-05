import java.io.*;
import java.util.*;

public class Main {
	
	static int ii(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String input[] = br.readLine().split(" ");
        	int n = ii(input[0]), a = ii(input[1]), b = ii(input[2]);
        	bw.write(Math.max(0, a - b) + " " + Math.min(a, n - b) + "\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}