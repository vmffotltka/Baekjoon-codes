import java.io.*;
import java.util.*;

public class Main {

    static int N, M, fuel;
    static int[][] map;

    static class Passenger {
        int sx, sy, dx, dy;

        Passenger(int sx, int sy, int dx, int dy) {
            this.sx = sx;
            this.sy = sy;
            this.dx = dx;
            this.dy = dy;
        }
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int dist = curr[2];

            if (x == endX && y == endY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
    static Passenger findNearestPassenger(int startX, int startY, List<Passenger> passengers) {
        Passenger nearestPassenger = null;
        int minDistance = Integer.MAX_VALUE;
        for (Passenger p : passengers) {
            int distance = bfs(startX, startY, p.sx, p.sy);
            if (distance != -1) {
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestPassenger = p;
                } else if (distance == minDistance) {
                    if (p.sx < nearestPassenger.sx || (p.sx == nearestPassenger.sx && p.sy < nearestPassenger.sy)) {
                        nearestPassenger = p;
                    }
                }
            }
        }
        return nearestPassenger;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startX, startY;
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int dx = Integer.parseInt(st.nextToken()) - 1;
            int dy = Integer.parseInt(st.nextToken()) - 1;
            passengers.add(new Passenger(sx, sy, dx, dy));
        }
        for (int i = 0; i < M; i++) {
            Passenger nextPassenger = findNearestPassenger(startX, startY, passengers);
            if (nextPassenger == null) {
                fuel = -1;
                break;
            }
            int distanceToPassenger = bfs(startX, startY, nextPassenger.sx, nextPassenger.sy);
            if (distanceToPassenger == -1 || distanceToPassenger > fuel) {
                fuel = -1;
                break;
            }
            fuel -= distanceToPassenger;
            startX = nextPassenger.sx;
            startY = nextPassenger.sy;

            int distanceToDestination = bfs(startX, startY, nextPassenger.dx, nextPassenger.dy);
            if (distanceToDestination == -1 || distanceToDestination > fuel) {
                fuel = -1;
                break;
            }
            fuel -= distanceToDestination;
            fuel += distanceToDestination * 2;
            startX = nextPassenger.dx;
            startY = nextPassenger.dy;

            passengers.remove(nextPassenger);
        }
        System.out.println(fuel);
    }
}