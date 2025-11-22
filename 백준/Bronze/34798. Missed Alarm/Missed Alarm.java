import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int start = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), ":");
        int end = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        
        System.out.print(start < end ? "YES" : "NO");
	}
}