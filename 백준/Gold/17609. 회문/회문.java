import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static boolean isPalin(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
        	String s = br.readLine();
        	
        	int left = 0, right = s.length() - 1, ans = 0;
        	while (left < right) {
        		if (s.charAt(left) == s.charAt(right)) {
        			left++;
        			right--;
        		}
        		else if (s.charAt(left + 1) == s.charAt(right) &&
        				isPalin(s.substring(left + 1, right + 1))) {
        			ans = 1;
        			break;
        		}
        		else if (s.charAt(left) == s.charAt(right - 1) &&
        				isPalin(s.substring(left, right))) {
        			ans = 1;
        			break;
        		}
        		else {
        			ans = 2;
        			break;
        		}
        	}
        	sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
	}
}