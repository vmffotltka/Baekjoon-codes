import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> s = new HashSet<>();
        s.add("ChongChong");
        
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	if (s.contains(input[0])) s.add(input[1]);
        	if (s.contains(input[1])) s.add(input[0]);
        }
        bw.write(String.valueOf(s.size()));
        bw.flush();
    }
}