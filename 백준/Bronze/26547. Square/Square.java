import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	String s = br.readLine();
        	if (s.length() != 1) bw.write(s + "\n");
        	for (int i = 1; i < s.length() - 1; i++) {
        		bw.write(s.charAt(i));
        		for (int j = 0; j < s.length() - 2; j++) bw.write(" ");
        		bw.write(s.charAt(s.length() - i - 1) + "\n");
        	}
        	for (int i = s.length() - 1; i >= 0; i--) bw.write(s.charAt(i));
        	bw.write("\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}