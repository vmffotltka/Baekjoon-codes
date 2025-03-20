import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        long[] cost = new long[3];
        for (int i = 0; i < 3; i++) cost[i] = Integer.parseInt(arr[i]);
        
        arr = br.readLine().split(" ");
        long[] cap = new long[3];
        for (int i = 0; i < 3; i++) cap[i] = Integer.parseInt(arr[i]);
        Arrays.sort(cost);
        Arrays.sort(cap);
        
        long ans = 0;
        for (int i = 0; i < 3; i++) ans += cost[i] * cap[i];
        
        bw.write(ans + "");
        
        bw.flush();
        bw.close(); br.close();
    }
}