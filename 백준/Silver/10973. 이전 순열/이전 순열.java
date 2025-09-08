import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(input[i]);
        }
        
        int idx = -1;
        for (int i = n - 1; i > 0; i--) {
        	if (arr[i - 1] > arr[i]) {
        		idx = i;
        		int c = -1, mn = Integer.MAX_VALUE;
        		for (int j = i; j < n; j++) {
        			if (arr[j] > arr[i - 1]) continue;
        			if (arr[i - 1] - arr[j] < mn) {
        				mn = arr[i - 1] - arr[j];
        				c = j;
        			}
        		}
        		int tmp = arr[i - 1];
        		arr[i - 1] = arr[c];
        		arr[c] = tmp;
        		break;
        	}
        }
        if (idx == -1) System.out.print(-1);
        else {
            Arrays.sort(arr, idx, n, Collections.reverseOrder());
        	
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
        		sb.append(String.format("%d ", arr[i]));
        	}
            System.out.print(sb.toString().strip());
        }
    }
}