import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int ans = 0;
        for (int i = 0; i <= s.length() - 4; i++) {
        	ans += (s.substring(i, i + 4).equals("kick") ? 1 : 0);
        }
        System.out.print(ans);
	}
}