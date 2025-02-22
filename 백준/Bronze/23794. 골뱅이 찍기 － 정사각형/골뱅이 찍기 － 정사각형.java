import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 2; i++) bw.write("@");
        bw.write("\n");
        for (int i = 0; i < n; i++) {
        	bw.write("@");
        	for (int j = 0; j < n; j++) bw.write(" ");
        	bw.write("@\n");
        }
        for (int i = 0; i < n + 2; i++) bw.write("@");
        bw.flush();
        bw.close(); br.close();
    }
}