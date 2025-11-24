import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> garoIdx = new ArrayList<>(), seroIdx = new ArrayList<>();
        garoIdx.add(0);
        garoIdx.add(garo);
        seroIdx.add(0);
        seroIdx.add(sero);
        
        while (n-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	int cmd = Integer.parseInt(st.nextToken());
        	int idx = Integer.parseInt(st.nextToken());
        	
        	if (cmd == 0)
        		seroIdx.add(idx);
        	else
        		garoIdx.add(idx);
        }
        
        Collections.sort(garoIdx);
        Collections.sort(seroIdx);
        
        int garoMx = 0, seroMx = 0;
        for (int i = 1; i < garoIdx.size(); i++)
        	garoMx = Math.max(garoMx, garoIdx.get(i) - garoIdx.get(i - 1));
        for (int i = 1; i < seroIdx.size(); i++)
        	seroMx = Math.max(seroMx, seroIdx.get(i) - seroIdx.get(i - 1));
    
        System.out.print(garoMx * seroMx);
    }
}