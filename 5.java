import java.util.Scanner;
public class Main5 {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Generator: ");
        String g = s.next();
        System.out.print("Enter Data: ");
        String d = s.next();
        String c = d + "0".repeat(g.length() - 1);
        c = d + r(c, g); 
        System.out.println("The transmitted Code Word is: " + c);
        System.out.print("Please enter the received Code Word: ");
        String received = s.next();   
        if (c.equals(received)) {
            System.out.println("The received code word is error-free.");
        } else {
            System.out.println("The received code word contains errors.");
        }
    }
        static String r(String n, String g) {
        char[] a = n.toCharArray();
        int l = g.length();
        for (int i = 0; i <= a.length - l; i++) 
            if (a[i] == '1') for (int j = 0; j < l; j++) a[i + j] = (a[i + j] == g.charAt(j)) ? '0' : '1';
        return new String(a, a.length - l + 1, l - 1);
    }
}
Enter Generator: 1100
Enter Data: 111000
The transmitted Code Word is: 111000100
Please enter the received Code Word: 111000100
The received code word is error-free.
