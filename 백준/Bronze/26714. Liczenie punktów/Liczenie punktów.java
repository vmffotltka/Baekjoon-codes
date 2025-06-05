import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        for (int i = 0; i < n / (n / 10); i++) {
        	boolean flag = true;
        	for (int j = 0; j < n / 10; j++) {
        		if (s.charAt(i * (n / 10) + j) == 'N') flag = false;
        	}
        	if (flag) cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close(); br.close();
    }
}