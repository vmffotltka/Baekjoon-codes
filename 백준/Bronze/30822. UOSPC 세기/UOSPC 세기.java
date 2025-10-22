import java.io.*;
import java.util.*;

public class Main {

	static int ALPHABETS = 'z' - 'a' + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[ALPHABETS];
        
        String s = br.readLine();
        for (char c : s.toCharArray()) {
        	cnt[c - 'a']++;
        }
        String uospc = "uospc";
        
        int mn = Integer.MAX_VALUE;
        for (char c : uospc.toCharArray()) {
        	mn = Math.min(mn, cnt[c - 'a']);
        }
        System.out.print(mn);
    }
}