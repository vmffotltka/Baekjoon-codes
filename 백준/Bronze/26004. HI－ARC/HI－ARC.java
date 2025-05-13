import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int[] arr = new int['z' - 'a' + 1];
        for (int i = 0; i < n; i++) {
        	arr[s.charAt(i) - 'A']++;
        }
        String hiarc = "HIARC";
        int ans = Integer.MAX_VALUE;
        for (char c : hiarc.toCharArray()) {
        	ans = Math.min(ans, arr[c - 'A']);
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}