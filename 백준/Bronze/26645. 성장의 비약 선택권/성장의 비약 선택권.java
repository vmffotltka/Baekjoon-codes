import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n < 206) bw.write("1");
        else if (n < 218) bw.write("2");
        else if (n < 229) bw.write("3");
        else bw.write("4");
        
        bw.flush();
        bw.close(); br.close();
    }
}