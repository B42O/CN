import java.util.Scanner;
public class Main {
    static final int INF = 9999;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = s.nextInt();
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = (char) ('A' + i);
        }
        int[][] d = new int[n][n];
        int[][] h = new int[n][n];
        System.out.println("Enter distances (9999 for no connection): ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    d[i][j] = 0;
                } else {
                    System.out.print("Distance from " + a[i] + " to " + a[j] + ": ");
                    d[i][j] = s.nextInt();
                }
                h[i][j] = (d[i][j] == INF) ? -1 : j; 
            }
        }
        System.out.println("\nInitial Tables:");
        p(a, d, h);
        for (int x = 0; x < n - 2; x++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (d[i][k] + d[k][j] < d[i][j]) {
                            d[i][j] = d[i][k] + d[k][j];
                            h[i][j] = h[i][k];
                        }
                    }
                }
            }
            System.out.println("\nAfter iteration " + (x + 1) + ":");
            p(a, d, h);
        }
        System.out.println("\nFinal Tables:");
        p(a, d, h);
    }
    private static void p(char[] a, int[][] d, int[][] h) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Table for node " + a[i] + ":\nDst\tDis\tHop");
            for (int j = 0; j < a.length; j++)
                System.out.printf("%c\t%s\t%s\n", a[j], (d[i][j] == INF) ? "INF" : d[i][j], (d[i][j] == INF) ? "-" : a[h[i][j]]);
            System.out.println();
        }
    }
}
Enter number of nodes: 4
Enter distances (9999 for no connection): 
Distance from A to B: 2
Distance from A to C: 9999
Distance from A to D: 1
Distance from B to A: 2
Distance from B to C: 3
Distance from B to D: 7
Distance from C to A: 9999
Distance from C to B: 3
Distance from C to D: 11
Distance from D to A: 1
Distance from D to B: 7
Distance from D to C: 11

Initial Tables:
Table for node A:
Dst     Dis     Hop
A       0       A
B       2       B
C       INF     -
D       1       D

Table for node B:
Dst     Dis     Hop
A       2       A
B       0       B
C       3       C
D       7       D

Table for node C:
Dst     Dis     Hop
A       INF     -
B       3       B
C       0       C
D       11      D

Table for node D:
Dst     Dis     Hop
A       1       A
B       7       B
C       11      C
D       0       D


After iteration 1:
Table for node A:
Dst     Dis     Hop
A       0       A
B       2       B
C       5       B
D       1       D

Table for node B:
Dst     Dis     Hop
A       2       A
B       0       B
C       3       C
D       3       A

Table for node C:
Dst     Dis     Hop
A       5       B
B       3       B
C       0       C
D       6       B

Table for node D:
Dst     Dis     Hop
A       1       A
B       3       A
C       6       A
D       0       D


After iteration 2:
Table for node A:
Dst     Dis     Hop
A       0       A
B       2       B
C       5       B
D       1       D

Table for node B:
Dst     Dis     Hop
A       2       A
B       0       B
C       3       C
D       3       A

Table for node C:
Dst     Dis     Hop
A       5       B
B       3       B
C       0       C
D       6       B

Table for node D:
Dst     Dis     Hop
A       1       A
B       3       A
C       6       A
D       0       D


Final Tables:
Table for node A:
Dst     Dis     Hop
A       0       A
B       2       B
C       5       B
D       1       D

Table for node B:
Dst     Dis     Hop
A       2       A
B       0       B
C       3       C
D       3       A

Table for node C:
Dst     Dis     Hop
A       5       B
B       3       B
C       0       C
D       6       B

Table for node D:
Dst     Dis     Hop
A       1       A
B       3       A
C       6       A
D       0       D
