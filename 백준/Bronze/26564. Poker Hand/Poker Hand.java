import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	HashMap<Character, Integer> map = new HashMap<>();
        	for (int i = 0; i < 5; i++) {
        		String s = st.nextToken();
        		map.put(s.charAt(0), map.getOrDefault(s.charAt(0), 0) + 1);
        	}
        	int mx = 0;
        	for (Character c : map.keySet()) {
        		mx = Math.max(mx, map.get(c));
        	}
        	bw.write(mx + "\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}