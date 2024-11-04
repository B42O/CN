import java.util.*;
public class Main6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = s.nextInt(); 
        int[][] g = new int[n][n]; 
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter the source node:");
        int src = s.nextInt(); 
        int[] d = dijkstra(g, src);
        System.out.println("Shortest distances:");
        for (int i = 0; i < n; i++) {
            System.out.println(src + " -> " + i + ": " + d[i]);
        }
        s.close(); 
    }
    static int[] dijkstra(int[][] g, int src) {
    int n = g.length;
    int[] d = new int[n];
    boolean[] v = new boolean[n];
    for (int i = 0; i < n; i++) {
        d[i] = 9999;
    }
    d[src] = 0;
    for (int i = 0; i < n; i++) {
        int u = -1;
        for (int j = 0; j < n; j++)
            if (!v[j] && (u == -1 || d[j] < d[u])) u = j;
        v[u] = true;
        for (int j = 0; j < n; j++)
            if (!v[j] && g[u][j] != 0)
                d[j] = Math.min(d[j], d[u] + g[u][j]);
    }
    return d;
    }
}
Enter the number of nodes:
6
Enter the adjacency matrix:
0 2 1 0 0 0
2 0 7 0 8 4
1 7 0 7 0 3
0 0 7 0 8 4
0 8 0 8 0 5
0 4 3 4 5 0
Enter the source node:
0
Shortest distances:
0 -> 0: 0
0 -> 1: 2
0 -> 2: 1
0 -> 3: 8
0 -> 4: 9
0 -> 5: 4
