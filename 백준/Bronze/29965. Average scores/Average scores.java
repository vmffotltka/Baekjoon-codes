import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        long mScore = 0, jScore = 0, mCnt = 0, jCnt = 0;
        for (int i = 0; i < n; i++) {
        	String[] input = br.readLine().split(" ");
        	if (input[0].equals("M")) {
        		mScore += Long.parseLong(input[1]);
        		mCnt++;
        	}
        	else {
        		jScore += Long.parseLong(input[1]);
        		jCnt++;
        	}
        }
        
        double mAv = (mCnt == 0 ? 0 : mScore / (double)mCnt);
        double jAv = (jCnt == 0 ? 0 : jScore / (double)jCnt);
        
        bw.write(mAv > jAv ? "M" : (mAv < jAv ? "J" : "V"));
        bw.flush();
    }
}