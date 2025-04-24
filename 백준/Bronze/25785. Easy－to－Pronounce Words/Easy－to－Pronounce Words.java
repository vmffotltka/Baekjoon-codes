import java.io.*;
import java.util.*;

public class Main {
	static final boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int flag = isVowel(s.charAt(0)) ? 1 : 0;
        boolean ans = true;
        for (int i = 1; i < s.length(); i++) {
        	if (isVowel(s.charAt(i)) && flag == 1) ans = false;
        	if (!isVowel(s.charAt(i)) && flag == 0) ans = false;
        	flag ^= 1;
        }
        bw.write(ans ? "1" : "0");
        bw.flush();
        bw.close(); br.close();
    }
}