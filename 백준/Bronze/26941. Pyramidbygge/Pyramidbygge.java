import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int len = 1;
        while (true) {
        	if (n < len * len) break;
        	n -= len * len;
        	len += 2;
        }
        bw.write((len - 1) / 2 + "");
        bw.flush();
        bw.close(); br.close();
    }
}