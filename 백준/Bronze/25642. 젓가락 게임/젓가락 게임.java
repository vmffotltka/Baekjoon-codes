import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int turn = 1;
        while (true) {
        	if (turn == 1) b += a;
        	else a += b;
        	turn ^= 1;
        	if (a >= 5) {bw.write("yj"); break;}
        	if (b >= 5) {bw.write("yt"); break;}
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}