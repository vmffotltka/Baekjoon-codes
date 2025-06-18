import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        bw.write((Math.min(n, m) * 2 + ((n + m) % 2 == 1 ? 1 : 0)) + "");
        
        bw.flush();
        bw.close(); br.close();
    }
}