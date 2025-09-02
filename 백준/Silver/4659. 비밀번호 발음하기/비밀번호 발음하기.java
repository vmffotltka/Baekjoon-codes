import java.io.*;
import java.util.*;

public class Main {

	static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? true : false;
	}
	
	static boolean vowel(String s) {
		for (char c : s.toCharArray()) {
			if (isVowel(c))
				return true;
		}
		return false;
	}
	
	static boolean streak2(String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) != 'e' && s.charAt(i) != 'o')
				return true;
		}
		return false;
	}
	
	static boolean streak3(String s) {
		int vow = 0, con = 0;
		for (char c : s.toCharArray()) {
			if (isVowel(c)) {
				if (con >= 3) return true;
				con = 0;
				vow++;
			}
			else {
				if (vow >= 3) return true;
				vow = 0;
				con++;
			}
		}
		return vow >= 3 || con >= 3 ? true : false;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
        	String s = br.readLine();
        	if (s.equals("end")) break;
        	
        	boolean ans = false;
        	if (vowel(s) && !streak2(s) && !streak3(s))
        		ans = true;
        	
        	sb.append(String.format("<%s> is ", s) + (ans ? "" : "not ") + "acceptable.\n");
        }
        System.out.print(sb.toString());
        //bw.flush();
    }
}