import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int av = 0;
        for (int i = 0; i < 5; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	av += a * l;
        }
        av /= 5;
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int kwf = Integer.parseInt(st.nextToken());
        System.out.print(av * n / kwf);
    }
}