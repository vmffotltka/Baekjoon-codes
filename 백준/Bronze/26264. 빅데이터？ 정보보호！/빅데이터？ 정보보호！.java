import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), b = 0;
        String s = br.readLine();
        for (char c : s.toCharArray()) {
        	if (c == 'b') b++;
        }
        if (b * 2 >= n) bw.write("bigdata? ");
        if (b * 2 <= n) bw.write("security! ");
        bw.flush();
        bw.close(); br.close();
    }
}