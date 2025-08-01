import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        
        while (true) {
        	long c = a % b;
        	if (c == 0) break;
        	a = b;
        	b = c;
        }
        for (int i = 0; i < b; i++) {
        	bw.write("1");
        }
        bw.flush();
	}
}