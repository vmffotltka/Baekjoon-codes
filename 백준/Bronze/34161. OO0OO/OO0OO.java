import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        br.readLine();
        br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
        	sb.append("-1\n");
        }
        System.out.print(sb.toString());
    }
}