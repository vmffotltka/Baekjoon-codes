import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[10][10];
        int ans = 0;
        for (int i = 0; i < 10; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String pre = st.nextToken();
        	arr[i][0] = pre;
        	boolean flag = true;
        	
        	for (int j = 1; j < 10; j++) {
        		arr[i][j] = st.nextToken();
        		if (!pre.equals(arr[i][j])) flag = false;
        	
        		pre = arr[i][j];
        	}
        	if (flag) ans = 1;
        }
        for (int j = 0; j < 10; j++) {
        	String pre = arr[0][j];
        	boolean flag = true;
        	for (int i = 1; i < 10; i++) {
        		if (!pre.equals(arr[i][j])) flag = false;
        		
        		pre = arr[i][j];
        	}
        	if (flag) ans = 1;
        }
        System.out.print(ans);
	}
}