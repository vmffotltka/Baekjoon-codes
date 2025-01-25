import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String nm[] = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        
        Map<String, Integer> cnt = new HashMap<>();
        List<String> v = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	if (s.length() < m) continue;
        	if (!cnt.containsKey(s)) v.add(s);
        	cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        
        v.sort((a, b) -> {
        	if (cnt.get(a).equals(cnt.get(b))) {
        		if (a.length() == b.length()) {
        			return a.compareTo(b);
        		}
        		return Integer.compare(b.length(), a.length());
        	}
        	return Integer.compare(cnt.get(b), cnt.get(a));
        });
        
        for (String s : v) {
        	bw.write(s);
        	bw.newLine();
        }
        bw.flush();
        bw.close(); br.close();
	}
}