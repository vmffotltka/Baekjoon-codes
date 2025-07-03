import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int f = Integer.parseInt(input[1]);
        int angle = (180 * f) / r;

        angle %= 360;

        bw.write(angle < 90 || angle > 270 ? "up" : "down");
        bw.flush(); 
    }
}   