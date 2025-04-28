import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        boolean tri = false, tri2 = false;
        int idx1 = s.indexOf('U'), idx2 = s.lastIndexOf('F');
        for (int i = 0; i < idx1; i++) bw.write("-");
        bw.write("U");
        for (int i = idx1 + 1; i < idx2; i++) bw.write("C");
        bw.write("F");
        for (int i = idx2 + 1; i < s.length(); i++) bw.write("-");
        bw.flush();
        bw.close(); br.close();
    }
}