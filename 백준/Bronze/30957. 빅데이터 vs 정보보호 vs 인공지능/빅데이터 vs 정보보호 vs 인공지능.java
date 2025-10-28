import java.io.*;
import java.util.*;

public class Main {

	static int ALPHABETS = 'Z' - 'A' + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String bsa = "BSA";
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] cnt = new int[ALPHABETS];
        
        int mx = -1;
        for (char c : s.toCharArray()) {
        	cnt[c - 'A']++;
        	mx = Math.max(mx, cnt[c - 'A']);
        }
        if (cnt['B' - 'A'] == cnt['S' - 'A'] && cnt['S' - 'A'] == cnt[0])
        	System.out.print("SCU");
        else {
            StringBuilder sb = new StringBuilder();
            for (char c : bsa.toCharArray()) {
            	if (cnt[c - 'A'] == mx) sb.append(c);
            }
            System.out.print(sb);
        }
    }
}