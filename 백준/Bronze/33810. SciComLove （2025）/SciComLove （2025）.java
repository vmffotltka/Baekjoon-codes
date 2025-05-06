import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String sci = "SciComLove";
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) != sci.charAt(i)) ans++;
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
    }
}