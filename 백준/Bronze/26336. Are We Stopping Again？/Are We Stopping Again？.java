import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int total = Integer.parseInt(input[0]);
            int gas = Integer.parseInt(input[1]);
            int food = Integer.parseInt(input[2]);
        	
        	int stops = 0;
            for (int mile = 1; mile < total; mile++) {
                if (mile % gas == 0 || mile % food == 0) {
                    stops++;
                }
            }

            bw.write(total + " " + gas + " " + food + "\n");
            bw.write(stops + "\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}