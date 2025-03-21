import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        if (!s.contains("U")) bw.write("U");
        if (!s.contains("A")) bw.write("A");
        if (!s.contains("P")) bw.write("P");
        if (!s.contains("C")) bw.write("C");
        bw.flush();
        bw.close(); br.close();
    }
}