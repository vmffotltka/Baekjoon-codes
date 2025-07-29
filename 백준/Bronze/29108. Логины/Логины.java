import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        boolean ans = true;
        for (int i = 2; i < s.length(); i++) {
        	if (!Character.isDigit(s.charAt(i))) ans = false;
        }
        bw.write(s.length() > 2 && s.substring(0, 2).equals("io") && ans ? "Correct" : "Incorrect");
        bw.flush();
	}
}