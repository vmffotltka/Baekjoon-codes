import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[2]);
        int predict = Integer.parseInt(input[1]);
        while (s-- > 0) {
        	String[] p = br.readLine().split(" ");
        	boolean tri = true;
        	for (int i = 1; i < p.length; i++) {
        		if (Integer.parseInt(p[i]) == predict)
        			tri = false;
        	}
        	bw.write(tri ? "REMOVE\n" : "KEEP\n");
        }
        bw.flush();
	}
}