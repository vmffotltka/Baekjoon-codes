import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int raise = Integer.parseInt(input[1]);
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(br.readLine());
        	if (p < raise) count1++;
        	else if (raise < p) count2++;
        }
        bw.write(count1 == count2 ? "0" : (count1 > count2 ? "1" : "2"));
        bw.flush();
        bw.close(); br.close();
    }
}