import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), ans = 0;
        String[] worked = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        	String[] tmp = br.readLine().split(" ");
        	int day = Integer.parseInt(tmp[0]), night = Integer.parseInt(tmp[1]);
        	if (worked[i].equals("1")) ans += Math.max(night - day, 0);
        }
        bw.write(ans + "");
        bw.flush();
        bw.close(); br.close();
	}
}