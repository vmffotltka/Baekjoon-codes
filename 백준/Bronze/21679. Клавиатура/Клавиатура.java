import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int arr[] = new int[101], cnt[] = new int[101], n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	int p = Integer.parseInt(st.nextToken());
        	arr[i] = p;
        }
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
        	int p = Integer.parseInt(st.nextToken()) - 1;
        	cnt[p]++;
        }
        for (int i = 0; i < n; i++) {
        	bw.write(arr[i] < cnt[i] ? "yes\n" : "no\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}