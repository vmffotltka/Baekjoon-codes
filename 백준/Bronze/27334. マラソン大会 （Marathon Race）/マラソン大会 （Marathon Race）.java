import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
        	int rank = 1;
        	for (int j = 0; j < n; j++) {
        		if (i == j) continue;
        		if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[j]))
        			rank++;
        	}
        	bw.write(rank + "\n");
        }
        
        bw.flush();
    }
}