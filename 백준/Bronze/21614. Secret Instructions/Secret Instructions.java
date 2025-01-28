import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String prev = "";
        while (true) {
        	String digits = br.readLine(), dir;
        	if (digits.equals("99999")) break;
        	int sum = (digits.charAt(0) - '0') + (digits.charAt(1) - '0');
        	if (sum % 2 == 1) dir = "left";
        	else if (sum == 0) dir = prev;
        	else dir = "right";
        	bw.write(dir + " " + digits.substring(2) + "\n");
        	prev = dir;
        }
        bw.flush();
        bw.close(); br.close();
	}
}