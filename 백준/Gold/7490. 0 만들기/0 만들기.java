import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static List<Character> cmd;
    static int N;
    static void solve(int depth) {
        if (depth == N - 1) {
            List<Integer> nums = new ArrayList<>();
            List<Character> cmds = new ArrayList<>();
            nums.add(1);
            for (int i = 2; i <= N; i++) {
                char c = cmd.get(i - 2);
                if (c == ' ')
                    nums.set(nums.size() - 1, nums.get(nums.size() - 1) * 10 + i);
                else {
                    nums.add(i);
                    cmds.add(c);
                }
            }
            int res = nums.get(0);
            for (int i = 1; i < nums.size(); i++) {
                char c = cmds.get(i - 1);
                if (c == '+')
                    res += nums.get(i);
                else
                    res -= nums.get(i);
            }
            if (res == 0) {
                sb.append(1);
                for (int i = 0; i < cmd.size(); i++) {
                    sb.append(cmd.get(i)).append(i + 2);
                }
                sb.append("\n");
            }
            return;
        }

        String command = " +-";
        for (int i = 0; i < 3; i++) {
            cmd.add(command.charAt(i));
            solve(depth + 1);
            cmd.remove(cmd.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            cmd = new ArrayList<>();
            solve(0);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}