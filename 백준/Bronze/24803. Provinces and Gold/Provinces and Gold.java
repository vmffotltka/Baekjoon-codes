import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);
        
        int p = a * 3 + b * 2 + c;
        if (p >= 8) bw.write("Province or ");
        else if (p >= 5) bw.write("Duchy or ");
        else if (p >= 2) bw.write("Estate or ");
        if (p >= 6) bw.write("Gold");
        else if (p >= 3) bw.write("Silver");
        else bw.write("Copper");
        
        bw.flush();
        bw.close(); br.close();
    }
}