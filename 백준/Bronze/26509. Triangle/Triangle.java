import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] p1 = br.readLine().split(" ");
        	String[] p2 = br.readLine().split(" ");
        	int a = Integer.parseInt(p1[0]);
        	int b = Integer.parseInt(p1[1]);
        	int c = Integer.parseInt(p1[2]);
        	int d = Integer.parseInt(p2[0]);
        	int e = Integer.parseInt(p2[1]);
        	int f = Integer.parseInt(p2[2]);

        	int arr1[] = { a, b, c };
        	int arr2[] = { d, e, f };
        	
        	Arrays.sort(arr1);
        	Arrays.sort(arr2);
        	
        	if (arr1[0] * arr1[0] + arr1[1] * arr1[1] == arr1[2] * arr1[2] &&
        			arr2[0] * arr2[0] + arr2[1] * arr2[1] == arr2[2] * arr2[2] &&
        			arr1[0] == arr2[0] && arr1[1] == arr2[1] && arr1[2] == arr2[2])
        		bw.write("YES\n");
        	else
        		bw.write("NO\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}