import java.util.*;

public class ReverseName {

    static String reverseCustomerName(String customerName) {

        StringBuilder sb = new StringBuilder(customerName);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        String reversed = reverseCustomerName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }
}