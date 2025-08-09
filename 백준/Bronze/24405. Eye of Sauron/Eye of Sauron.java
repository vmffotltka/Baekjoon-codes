import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(s.length() % 2 == 1 || s.indexOf("()") != s.length() / 2 - 1 ? "fix" : "correct");
        
        bw.flush();
    }
}