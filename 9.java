import java.net.*;
import java.util.*;
public class EXP9 {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n;
        do {
            System.out.println("1. DNS\n2. Exit\nEnter your choice:");
            n = s.nextInt();
            if (n == 1) {
                System.out.println("Enter the hostname:");
                String h = s.next();
                try {
                    InetAddress ad = InetAddress.getByName(h);
                    System.out.println("Host Name: " + ad.getHostName() + "\nIP Address: " + ad.getHostAddress());
                } catch (UnknownHostException e) {
                    System.out.println("Unable to find IP address. Please enter a valid hostname.");
                }
            }
        } while (n == 1);
        s.close();
    }
}
1. DNS
2. Exit
Enter your choice:
1
Enter the hostname:
www.google.com
Host Name: www.google.com
IP Address: 209.85.200.147
1. DNS
2. Exit
Enter your choice:
1
Enter the hostname:
gprec.z
Unable to find IP address. Please enter a valid hostname.
1. DNS
2. Exit
Enter your choice:2
