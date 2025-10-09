import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	int d, m, y;
        	String s = br.readLine();
        	String[] input = new String[3];
        	if (!s.contains(".")) {
            	input = s.split("/");
            	d = Integer.parseInt(input[1]);
            	m = Integer.parseInt(input[0]);
        	}
        	else {
        		input = s.split("\\.");
        		d = Integer.parseInt(input[0]);
        		m = Integer.parseInt(input[1]);
        	}
        	y = Integer.parseInt(input[2]);
        	
        	bw.write(String.format("%02d.%02d.%04d %02d/%02d/%04d\n", d, m, y, m, d, y));
        }
        bw.flush();
    }
}