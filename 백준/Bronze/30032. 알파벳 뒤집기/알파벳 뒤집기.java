import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Character>[] m = new HashMap[3];
        m[1] = new HashMap<>();
        m[2] = new HashMap<>();
        
        m[1].put('d', 'q');
        m[1].put('q', 'd');
        m[1].put('b', 'p');
        m[1].put('p', 'b');

        m[2].put('d', 'b');
        m[2].put('b', 'd');
        m[2].put('q', 'p');
        m[2].put('p', 'q');
        
        String[] input = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
        	String s = br.readLine();
        	for (char c : s.toCharArray()) {
        		sb.append(m[Integer.parseInt(input[1])].get(c));
        	}
        	sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}