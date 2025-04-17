import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int height = Integer.parseInt(input[0]);
        	int weight = Integer.parseInt(input[1]);
        	
        	if (height <= 140) bw.write("6\n");
        	else if (height < 146) bw.write("5\n");
        	else if (height < 159) bw.write("4\n");
        	else if (height < 161) {
        		if (16 * height * height <= weight * 10000 && weight * 10000 < 35 * height * height)
        			bw.write("3\n");
        		else
        			bw.write("4\n");
        	}
        	else if (height < 204) {
        		if (20 * height * height <= weight * 10000 && weight * 10000 < 25 * height * height)
        			bw.write("1\n");
        		else if ((18.5 * height * height <= weight * 10000 && weight * 10000 < 20 * height * height) ||
        				(25 * height * height <= weight * 10000 && weight * 10000 < 30 * height * height))
        			bw.write("2\n");
        		else if ((16 * height * height <= weight * 10000 && weight * 10000 < 18.5 * height * height) ||
        				(30 * height * height <= weight * 10000 && weight * 10000 < 35 * height * height))
        			bw.write("3\n");
        		else
        			bw.write("4\n");
        	}
        	else bw.write("4\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}