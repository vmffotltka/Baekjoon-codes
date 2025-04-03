import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int b = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        int l = Integer.parseInt(input[3]);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i * b <= l; i++) {
        	for (int j = 0; i * b + j * d <= l; j++) {
        		for (int k = 0; i * b + j * d + k * c <= l; k++) {
        			if (i * b + j * d + k * c == l)
        				sb.append(i + " " + j + " " + k + "\n");
        		}
        	}
        }
        bw.write(sb.toString());
        if (sb.isEmpty()) bw.write("impossible");
        bw.flush();
        bw.close(); br.close();
    }
}