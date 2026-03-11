import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> smallPQ = new PriorityQueue<>(), bigPQ = new PriorityQueue<>(Collections.reverseOrder());
            List<Integer> nums = new ArrayList<>();
            for (int k = (n + 9) / 10; k > 0; k--) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int flag = 1;
                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());
                    if (smallPQ.size() == bigPQ.size()) {
                        bigPQ.offer(num);
                    } else {
                        smallPQ.offer(num);
                    }

                    if (!smallPQ.isEmpty() && !bigPQ.isEmpty() && smallPQ.peek() < bigPQ.peek()) {
                        int smallNum = smallPQ.poll();
                        int bigNum = bigPQ.poll();
                        smallPQ.offer(bigNum);
                        bigPQ.offer(smallNum);
                    }

                    if (flag == 1)
                        nums.add(bigPQ.peek());

                    flag ^= 1;
                }
            }
            sb.append(nums.size()).append("\n");
            for (int i = 0; i < nums.size(); i++) {
                sb.append(nums.get(i)).append(" ");
                if ((i + 1) % 10 == 0)
                    sb.append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}