import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[1001];
        int mx = -1, left = -1, right = -1;
        
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int idx = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	
        	height[idx] = h;
        	if (h > mx) {
        		mx = h;
        		left = idx;
        		right = idx;
        	}
        	else if (h == mx) {
        		left = Math.min(left, idx);
        		right = Math.max(right, idx);
        	}
        }
        
        int ans = 0, pre = 0, pIndex = 0;
        for (int i = 0; i <= left; i++) {
        	if (height[i] > pre) {
        		ans += pre * (i - pIndex);
        		pre = height[i];
        		pIndex = i;
        	}
        }
        pre = 0; pIndex = 1000;
        for (int i = 1000; i >= right; i--) {
        	if (height[i] > pre) {
        		ans += pre * (pIndex - i);
        		pre = height[i];
        		pIndex = i;
        	}
        }
        System.out.print(ans + (right - left + 1) * mx);
    }
}