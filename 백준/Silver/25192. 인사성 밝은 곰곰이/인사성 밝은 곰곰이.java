import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), ans = 0;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
        	String s = br.readLine();
        	if (s.equals("ENTER")) { ans += set.size(); set.clear(); }
        	else set.add(s);
        }
        ans += set.size();
        bw.write(ans + "");
        
        bw.flush();
        bw.close(); br.close();
	}
}