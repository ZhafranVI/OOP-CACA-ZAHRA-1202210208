import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        Restaurant restoran = new Restaurant(); 
        int customerID;
        int orderQty;
        try{
            System.out.print("Input Customer ID : ");
            customerID = userinput.nextInt();

            System.out.print("Input how much food to made : ");
            orderQty = userinput.nextInt();

            Thread thread1 = new Thread(restoran);
            Waiters wtr = new Waiters(customerID, orderQty);
            Thread thread2 = new Thread(wtr);

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

        } catch (Exception e){
            System.out.println("!!! input must be integer !!!".toUpperCase());
        }
        userinput.close();
    }
}
