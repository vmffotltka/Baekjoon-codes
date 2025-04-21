import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), c1 = 0, c2 = 0;
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == 's') c1++;
        	else c2++;
        }
        for (int i = 0; i < n; i++) {
        	if (c1 == c2) {
        		bw.write(s.substring(i));
        		break;
        	}
        	if (s.charAt(i) == 's') c1--;
        	else c2--;
        }
        bw.flush();
        bw.close(); br.close();
    }
}