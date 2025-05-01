import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int y = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        int ansY = Math.max(y - 2, 0) * 4 + (y >= 2 ? 9 : 0) + (y >= 1 ? 15 : 0);
        int ansM = 0;
        
        if (y < 1) ansM = m * 15;
        else if (y < 2) ansM = m * 9;
        else ansM = m * 4;
        
        bw.write((ansY + ansM / 12) + " " + ansM % 12);
        bw.flush();
        bw.close(); br.close();
    }
}