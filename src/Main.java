
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Customer usr;
    private static Admin admin;

    private static final String adminEmail = "admin@iiitd.ac.in";
    private static final String adminPassword = "admin";

    private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final ArrayList<Admin> admins = new ArrayList<>();
    private static final ArrayList<Food> menu = new ArrayList<>();
    private static final ArrayList<Order> orders = new ArrayList<>();

    private static void prepopulate(){
        Admin a1 = new Admin(adminEmail, adminPassword);
        Admin a2 = new Admin("root@gmail.com", adminPassword);
        Admin a3 = new Admin("home@gmail.com", adminPassword);

        Customer c1 = new Customer("sanchay23478@iiitd.ac.in","Sanchay Singh","123",1);
        Customer c2 = new Customer("test@gmail.com","Foo","123",0);
        Customer c3 = new Customer("test2@gmail.com","Bar","123",0);

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        admins.add(a1);
        admins.add(a2);
        admins.add(a3);

        Food f1 = new Food("Pepsi",20,1,"drinks",true);
        Food f2 = new Food("Coke",20,2,"drinks",true);
        Food f3 = new Food("Kurkure Paneer Momos",80,3,"snacks",true);

        menu.add(f1);
        menu.add(f2);
        menu.add(f3);

    }

    private static void printDashes(){
        System.out.println("-------------------------------------------------------");
    }

    private static void logIN(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            printDashes();
            System.out.println("Please enter your choice:\n1.To Login\n2.To Sign Up\n3.To Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            boolean found = false;

            if(choice == 1){
                System.out.println("Please enter your email:");
                String email = scanner.nextLine();

                for(Customer c : customers){
                    if(c.getEmail().equals(email)){
                        System.out.println("Please enter your password:");
                        String password = scanner.nextLine();
                        if(password.equals(c.getPassword())){
                            usr = c;
                            found = true;
                            break;
                        }
                    }
                }

                if(found) break;

                for(Admin a : admins){
                    if(a.getEmail().equals(email)){
                        System.out.println("Please enter your password:");
                        String password = scanner.nextLine();
                        if(password.equals(a.getPassword())){
                            admin = a;
                            found = true;
                            break;
                        }
                    }
                }

                if(found) break;

                System.out.println("Incorrect Email or Password, please try again.");


            }else if(choice == 2){

                printDashes();
                System.out.println("Please enter your email:");
                String email = scanner.nextLine();

                for(Customer c : customers){
                    if(c.getEmail().equals(email)){
                        found = true;
                    }
                }

                for(Admin a : admins){
                    if(a.getEmail().equals(email)){
                        found = true;
                    }
                }

                if(found){
                    System.out.println("Account With Given Email already exists.");
                    continue;
                }

                System.out.println("Please enter your password:");
                String password = scanner.nextLine();

                System.out.println("Please enter your Name:");
                String name = scanner.nextLine();

                Customer csr = new Customer(email, name, password,0);

                customers.add(csr);
                usr = csr;

                System.out.println("User Successfully Logged in.");
                break;

            }else if(choice == 3){
                printDashes();
                System.out.println("Exiting...");
                printDashes();
                System.exit(0);
            }else{
                System.out.println("Please enter a valid choice");
            }
        }

        usr();
    }

    public static void usr(){
        Scanner scanner = new Scanner(System.in);
        if(usr!=null){

            printDashes();
            System.out.println("Logged In As: "+usr.getName());

            while (true){
                printDashes();

                usr.displayGUI();

                int choice123 = scanner.nextInt();
                scanner.nextLine();

                if(choice123 == 1) usr.browseMenu(menu);
                else if(choice123 == 2) {
                    Order o = usr.cart(menu);
                    if(o!=null) orders.add(o);
                }
                else if(choice123 == 3) {
                    Order o = usr.orders(orders);
                    if(o!=null) orders.add(o);
                }
                else if(choice123 == 4) usr.review(menu);
                else if(choice123 == 5) {
                    usr=null;
                    logIN();
                }
                else if(choice123 == 6 && usr.getType()==0){
                    usr.VIP();
                }
                else System.out.println("Please enter a valid choice");

            }

        }
        else if(admin!=null){
            printDashes();
            System.out.println("Logged In As Admin");

            while (true){

                printDashes();

                admin.displayGUI();
                int choice34 = scanner.nextInt();
                scanner.nextLine();

                if(choice34==1) admin.manageMenu(menu,orders);
                else if(choice34 == 2) admin.manageOrders(orders);
                else if(choice34 == 3) admin.report(orders);
                else if(choice34 == 4) {
                    admin=null;
                    logIN();
                }
                else System.out.println("Please enter a valid choice");


            }
        }
    }

    public static void main(String[] args) {
        prepopulate();

        printDashes();
        System.out.println("---------------Welcome To Byte Me!---------------------");

        logIN();

    }
}