import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int d = Integer.parseInt(input[0]);
        int tired = Integer.parseInt(input[1]);
        int invigor = Integer.parseInt(input[2]);
        
        int[] arr = new int[tired];
        for (int i = 0; i < tired; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < invigor; i++) {
        	d += Integer.parseInt(br.readLine());
        }
        
        int ans = invigor;
        for (int i = 0; i < tired; i++) {
        	if (d >= arr[i]) {
        		ans++;
        		d -= arr[i];
        	}
        	else break;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}