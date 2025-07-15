import java.io.*;
import java.util.*;

public class Main {
    public static int dateToDay(String s) {
    	return Integer.parseInt(s.substring(0, 4)) * 365
        		+ Integer.parseInt(s.substring(5, 7)) * 31
        		+ Integer.parseInt(s.substring(8, 10));
    }
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int curTime = dateToDay(s);
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	String input = br.readLine();
        	int time = dateToDay(input);
        	if (curTime <= time) ans++;
        }
        bw.write(ans + "");
        bw.flush();
    }
}