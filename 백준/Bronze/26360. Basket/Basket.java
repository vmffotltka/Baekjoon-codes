import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int success = Integer.parseInt(br.readLine());
        int penalty = Integer.parseInt(br.readLine());
        int ans = success == 1 ? x : 0;
        
        if (penalty == 1) {
            for (int i = 0; i < (success == 1 ? 1 : x); i++) {
            	int p = Integer.parseInt(br.readLine());
            	ans += p;
            }
        }
        bw.write(ans+ "");
        bw.flush();
        bw.close(); br.close();
    }
}