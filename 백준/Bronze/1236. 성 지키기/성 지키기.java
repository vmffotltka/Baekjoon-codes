import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        String[] arr = new String[n];
        int[] seroSum = new int[n], garoSum = new int[m];
        for (int i = 0; i < n; i++) {
        	arr[i] = br.readLine();
        	for (int j = 0; j < m; j++) {
        		int p = arr[i].charAt(j) == 'X' ? 1 : 0;
        		seroSum[i] += p;
        		garoSum[j] += p;
        	}
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	if (seroSum[i] > 0) continue;
        	for (int j = 0; j < m; j++) {
        		if (garoSum[j] == 0) {
        			ans++;
        			seroSum[i] = 1;
        			garoSum[j] = 1;
        			break;
        		}
        	}
        }
        for (int i = 0; i < n; i++) {
        	if (seroSum[i] == 0) ans++;
        }
        for (int j = 0; j < m; j++) {
        	if (garoSum[j] == 0) ans++;
        }
        
        System.out.print(ans);
    }
}