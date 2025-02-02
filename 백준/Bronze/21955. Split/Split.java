import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        bw.write(s.substring(0,  s.length() / 2) + " " + s.substring(s.length() / 2));
        bw.flush();
        bw.close(); br.close();
	}
}