import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i = 0; i < s.length(); i += n) {
        	bw.write(s.charAt(i));
        }
        bw.flush();
        bw.close(); br.close();
    }
}