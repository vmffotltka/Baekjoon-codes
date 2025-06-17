import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        double n = Double.parseDouble(input[0]);
        double t = Double.parseDouble(input[1]);
        double m = Double.parseDouble(br.readLine());
        
        input = br.readLine().split(" ");
        double x = Double.parseDouble(input[0]);
        double y = Double.parseDouble(input[1]);
        
        double before = m / x / 60, after = (n - m) / y / 60;
        bw.write(Math.max(0, (int)Math.ceil(before + after - t)) + "");
        
        bw.flush();
        bw.close(); br.close();
    }
}