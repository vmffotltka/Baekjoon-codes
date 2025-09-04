import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] votes = new int[50];
        
        int mx = -1;
        for (int i = 0; i < n; i++) {
        	votes[i] = Integer.parseInt(br.readLine());
        	mx = Math.max(mx, votes[i]);
        }
        
        int maesu = 0;
        while (true) {
        	if (votes[0] > mx) break;
        	
        	for (int i = 1; i < n; i++) {
        		if (votes[i] == mx) {
        			votes[i]--;
        			votes[0]++;
        			maesu++;
        		}

            	if (votes[0] > mx) break;
        	}

        	mx--;
        }
        System.out.print(String.valueOf(maesu));
    }
}