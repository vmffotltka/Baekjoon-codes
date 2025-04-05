import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        long pre = 1;
        while (n-- > 0) {
        	String[] input = br.readLine().split(" ");
        	long a = Long.parseLong(input[0]);
        	long b = Long.parseLong(input[2]);
        	if (input[1].equals("+")) {
        		pre = a + b - pre;
        	}
        	else if (input[1].equals("-")) {
        		pre *= a - b;
        	}
        	else if (input[1].equals("*")) {
        		pre = (a * b) * (a * b);
        	}
        	else {
        		pre = (a % 2 == 0 ? a / 2 : (a + 1) / 2);
        	}
        	bw.write(pre + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}