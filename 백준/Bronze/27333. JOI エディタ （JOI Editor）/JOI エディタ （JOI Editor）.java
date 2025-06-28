import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
        	if (i != n - 1 && s.charAt(i + 1) == s.charAt(i)) {
        		char newChar = (char)(s.charAt(i) - ('a' - 'A'));
        		bw.write(newChar + "" + newChar);
        		i++;
        	}
        	else bw.write(s.charAt(i));
        }
        
        bw.flush();
    }
}