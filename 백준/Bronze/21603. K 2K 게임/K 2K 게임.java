import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String nk[] = br.readLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        for (int i = 1; i <= n; i++) {
        	if ((i % 10) == k % 10 || (i % 10) == (k * 2) % 10) continue;
        	arr.add(i);
        }
        bw.write(arr.size() + "\n");
        for (int i : arr) {
        	bw.write(i + " ");
        }
        bw.flush();
        bw.close(); br.close();
	}
}