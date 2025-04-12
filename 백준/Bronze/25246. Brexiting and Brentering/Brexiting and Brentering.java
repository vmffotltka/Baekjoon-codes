import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int idx = s.length() - 1;
        for (; idx >= 0; idx--) {
        	if (s.charAt(idx) == 'a' || s.charAt(idx) == 'e' || s.charAt(idx) == 'i' || s.charAt(idx) == 'o' || s.charAt(idx) == 'u') {
        		break;
        	}
        }
        for (int i = 0; i <= idx; i++) bw.write(s.charAt(i));
        bw.write("ntry");
        bw.flush();
        bw.close(); br.close();
    }
}