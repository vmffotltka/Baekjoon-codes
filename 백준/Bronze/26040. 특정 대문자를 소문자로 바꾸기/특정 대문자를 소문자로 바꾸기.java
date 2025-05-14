import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i].charAt(0);
        	s = s.replace(c, (char)(c + 'a' - 'A'));
        }
        bw.write(s);
        bw.flush();
        bw.close(); br.close();
    }
}