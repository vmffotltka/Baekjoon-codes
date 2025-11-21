import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> limits = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	limits.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(limits, Collections.reverseOrder());
        
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
        	boxes.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(boxes, Collections.reverseOrder());
        if (limits.get(0) < boxes.get(0)) {
        	System.out.print(-1);
        	return;
        }
        
        int time = 0;
        while (!boxes.isEmpty()) {
        	int boxIdx = 0, craneIdx = 0;
        	while (craneIdx < n) {
        		if (boxIdx == boxes.size()) break;
        		
        		if (limits.get(craneIdx) >= boxes.get(boxIdx)) {
        			boxes.remove(boxIdx);
        			craneIdx++;
        		}
        		else boxIdx++;
        	}
        	time++;
        }
        System.out.print(time);
    }
}