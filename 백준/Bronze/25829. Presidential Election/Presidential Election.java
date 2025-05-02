import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int mv1 = 0, mv2 = 0, ev1 = 0, ev2 = 0;
        while (n-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int e = Integer.parseInt(input[0]);
        	int v1 = Integer.parseInt(input[1]);
        	int v2 = Integer.parseInt(input[2]);
        	mv1 += v1;
        	mv2 += v2;
        	if (v1 > v2) ev1 += e;
        	else if (v1 < v2) ev2 += e;
        }
        bw.write(mv1 > mv2 && ev1 > ev2 ? "1" : (mv1 < mv2 && ev1 < ev2 ? "2" : "0"));
        bw.flush();
        bw.close(); br.close();
    }
}