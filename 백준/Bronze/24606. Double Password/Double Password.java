import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        
        int ans = 1;
        for (int i = 0; i < 4; i++) {
        	if (a.charAt(i) != b.charAt(i)) ans *= 2;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}