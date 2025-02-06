import java.io.*;
import java.util.*;

public class Main {
	
	static int ii(char s) {
		return s - '0';
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String input[] = br.readLine().split(" ");
        	String s = input[0], e = input[1];
        	int k = Integer.parseInt(input[2]);
        	int start = ii(s.charAt(0)) * 10 * 60 * 60 + ii(s.charAt(1)) * 60 * 60 + ii(s.charAt(3)) * 10 * 60 + ii(s.charAt(4)) * 60 + ii(s.charAt(6)) * 10 + ii(s.charAt(7));
        	int end = ii(e.charAt(0)) * 10 * 60 * 60 + ii(e.charAt(1)) * 60 * 60 + ii(e.charAt(3)) * 10 * 60 + ii(e.charAt(4)) * 60 + ii(e.charAt(6)) * 10 + ii(e.charAt(7));
        	if (start >= end) end += 24 * 60 * 60;
        	if (start + k * 60 <= end) bw.write("Perfect\n");
        	else if (start + k * 60 <= end + 60 * 60) bw.write("Test\n");
        	else bw.write("Fail\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}