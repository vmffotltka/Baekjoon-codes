import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0, b = 0;
        for (int i = 1; i <= 9; i++) {
        	System.out.println("? A " + i);
        	int q = Integer.parseInt(br.readLine());
        	
        	if (q == 1) {
        		a = i;
        		break;
        	}
        }
        for (int i = 1; i <= 9; i++) {
        	System.out.println("? B " + i);
        	int q = Integer.parseInt(br.readLine());
        	
        	if (q == 1) {
        		b = i;
        		break;
        	}
        }
        System.out.println("! " + (a + b));
    }
}