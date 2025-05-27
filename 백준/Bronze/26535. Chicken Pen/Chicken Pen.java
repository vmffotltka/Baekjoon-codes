import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int p = (int)Math.ceil(Math.sqrt(n));
        for (int i = 0; i < p + 2; i++) bw.write("x");
        bw.write("\n");
        for (int i = 0; i < p; i++) {
        	bw.write("x");
        	for (int j = 0; j < p; j++) bw.write(".");
        	bw.write("x\n");
        }
        for (int i = 0; i < p + 2; i++) bw.write("x");
        bw.flush();
        bw.close(); br.close();
    }
}