import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int time = Integer.parseInt(br.readLine());
        
        int r = 0, g = 0, y = 0, i = 0;
        while (true) {
        	int cur = Integer.parseInt(input[i]);
        	if (i == 0) {
        		if (time <= cur) {
        			g += time;
        			break;
        		}
        		else  {
        			time -= cur;
        			g += cur;
        		}
        	}
        	else if (i == 1) {
        		if (time <= cur) {
        			g += time / 2;
        			break;
        		}
        		else {
        			time -= cur;
        			g += cur / 2;
        		}
        	}
        	else if (i == 2) {
        		if (time <= cur) {
        			y += time;
        			break;
        		}
        		else {
        			time -= cur;
        			y += cur;
        		}
        	}
        	else if (i == 3) {
        		if (time <= cur) {
        			r += time;
        			break;
        		}
        		else {
        			r += cur;
        			time -= cur;
        		}
        	}
        	else {
        		if (time <= cur) {
        			y += time; r += time;
        			break;
        		}
        		else {
        			time -= cur;
        			y += cur; r += cur;
        		}
        	}
        	i = (i + 1) % 5;
        }
        bw.write(r + " " + y + " " + g);
        bw.flush();
	}
}