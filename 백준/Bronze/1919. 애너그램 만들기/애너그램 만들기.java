import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine(), s2 = br.readLine();
        int[] cnt = new int['z' - 'a' + 1], cnt2 = new int['z' - 'a' + 1];
        for (int i = 0; i < s1.length(); i++) cnt[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++) cnt2[s2.charAt(i) - 'a']++;
        int ans = 0;
        for (int i = 0; i <= 'z' - 'a'; i++)
        	ans += Math.abs(cnt[i] - cnt2[i]);
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
	}
}