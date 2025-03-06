import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine(), s2 = br.readLine();
       	int row = Math.abs((s1.charAt(0) - 'a') - (s2.charAt(0) - 'a'));
       	int col = Math.abs((s1.charAt(1) - '0') - (s2.charAt(1) - '0'));
        bw.write(Math.min(row, col) + " " + Math.max(row, col));
        
        bw.flush();
        bw.close(); br.close();
    }
}