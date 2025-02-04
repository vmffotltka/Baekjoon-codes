import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String input[] = br.readLine().split(" ");
        	int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]), c = Integer.parseInt(input[2]);
        	if (a >= 1) {
        		bw.write(a + 2 * b >= c ? "YES\n" : "NO\n");
        	}
        	else {
        		bw.write(c % 2 == 1 || b * 2 < c ? "NO\n" : "YES\n");
        	}
        }
        bw.flush();
        bw.close(); br.close();
	}
}