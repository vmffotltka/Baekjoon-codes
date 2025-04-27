import java.io.*;
import java.util.*;

public class Main {
	static int ALPHABETS = 'z' - 'a' + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[ALPHABETS];
        String s = br.readLine();
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        int even = 0, odd = 0;
        for (int i = 0; i < ALPHABETS; i++) {
        	if (arr[i] == 0) continue;
        	if (arr[i] % 2 == 0) even++;
        	else odd++;
        }
        bw.write(even > 0 && odd == 0 ? "0" : (odd > 0 && even == 0 ? "1" : "0/1"));
        bw.flush();
        bw.close(); br.close();
    }
}