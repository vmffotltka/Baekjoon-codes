import java.io.*;
import java.util.*;

public class Main {

	static int ALPHABETS = 'z' - 'a' + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] cnt = new int[ALPHABETS];
        
        int mx = -1;
        for (char c : s.toCharArray()) {
        	if (Character.isLowerCase(c)) {
        		cnt[c - 'a']++;
        		mx = Math.max(mx, cnt[c - 'a']);
        	}
        }
        System.out.print(mx);
    }
}