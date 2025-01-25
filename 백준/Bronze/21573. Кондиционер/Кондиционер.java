import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String ab[] = br.readLine().split(" ");
        String s = br.readLine();
        int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]);
        if (s.equals("freeze")) bw.write(Math.min(a, b) + "");
        else if (s.equals("heat")) bw.write(Math.max(a, b) + "");
        else if (s.equals("auto")) bw.write(b + "");
        else bw.write(a + "");
        bw.flush();
        bw.close(); br.close();
	}
}