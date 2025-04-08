import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        if (s.substring(s.length() - 3, s.length()).equals("eh?"))
        	bw.write("Canadian!");
        else
        	bw.write("Imposter!");
        bw.flush();
        bw.close(); br.close();
    }
}