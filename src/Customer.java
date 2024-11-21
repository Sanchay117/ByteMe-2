
import java.util.*;

public class Customer {
    private final String email;
    private final String name;
    private final String password;

    private final Map<Food, Integer> cart = new HashMap<>();
    private final ArrayList<Order> orders = new ArrayList<>();

    private int type; // 1 for vip 0 for regular

    public Customer(String email, String name, String password,int type) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    private static void printDashes(){
        System.out.println("-------------------------------------------------------");
    }

    public String getEmail() {
        return email;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void VIP(){
        printDashes();
        System.out.println("Thanks! You are Now A VIP!");
        type=1;
    }

    public void displayGUI(){
        System.out.println("Press\n1.To Browse Menu");
        System.out.println("2.To View/Modify Cart");
        System.out.println("3.To Track Orders");
        System.out.println("4.To Review");
        System.out.println("5.To Exit");
        if(type==0){
            System.out.println("6.Pay To Become VIP");
        }
    }

    public void browseMenu(ArrayList<Food> Menu){
        Scanner scanner = new Scanner(System.in);

        ArrayList<Food> menu = new ArrayList<>(Menu);

        while (true){
            printDashes();

            System.out.println("Press\n1.To View All Items\n2.To search By Name\n3.To Filter by category\n4.Sort By Price\n5.Go Back");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            if(choice2==1){
                printDashes();
                for(Food f : menu){
                    System.out.print(f.getID()+".");
                    System.out.println(f);
                }
            }else if(choice2==2){
                printDashes();

                System.out.println("Name:");
                String name = scanner.nextLine();

                boolean found = false;

                for(Food f : menu){
                    if(f.getName().contains(name)){
                        System.out.println(f.getID()+"."+ f);
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("No such Item");
                }

            }else if(choice2==3){
                printDashes();

                System.out.println("Category:");
                String category = scanner.nextLine();

                boolean found = false;

                for(Food f : menu){
                    if(f.getCategory().equals(category)){
                        System.out.println(f.getID()+"."+ f);
                        found = true;
                    }
                }

                if(!found){
                    System.out.println("No such Category");
                }
            } else if (choice2 == 4) {
                printDashes();

                while (true){
                    System.out.println("Press\n1.To Sort In Ascending Order\n2.To Sort In Descending order\n");
                    int choice3 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice3==1){
                        menu.sort(Comparator.comparing(Food::getPrice));
                    }
                    else if(choice3==2){
                        menu.sort(Comparator.comparing(Food::getPrice).reversed());
                    }
                    else{
                        System.out.println("Invalid Choice");
                        continue;
                    }

                    for(Food f : menu){
                        System.out.println(f.getID()+"."+ f);
                    }

                    break;
                }

            }else if(choice2 == 5){
                break;
            }else{
                System.out.println("Please enter a valid choice");
            }
        }
    }

    public Order cart(ArrayList<Food> menu){
        Scanner scanner = new Scanner(System.in);

        while (true){
            printDashes();

            System.out.println("Press\n1.To Add Items\n2.To Modify Quantities\n3.To Remove Items\n4.View Total\n5.To Checkout\n6.To Go Back");
            int choice2 = scanner.nextInt();
            scanner.nextLine();

            if(choice2==1){
                printDashes();

                System.out.println("Select Food to add to cart By ID\n");
                for(Food f : menu){
                    if(f.isAvailable()){
                        System.out.println(f.getID()+"."+ f);
                    }
                }

                System.out.println("ID:");
                int id = scanner.nextInt();
                scanner.nextLine();

                Food food = null;
                for(Food f : menu){
                    if(f.getID() == id && f.isAvailable()){
                        food = f;
                    }
                }

                if(food==null){
                    System.out.println("No such ID");
                    continue;
                }

                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                cart.put(food,cart.getOrDefault(food,0)+quantity);
                System.out.println("Added Item!");
            }
            else if(choice2==2){
                printDashes();

                System.out.println("Your Cart:\n");
                for(Map.Entry<Food, Integer> entry : cart.entrySet()){
                    System.out.println(entry.getKey().getID()+"."+ entry.getKey() + " " + entry.getValue() + "[QTY.]");
                }

                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                Food fd = null;

                for(Map.Entry<Food, Integer> entry : cart.entrySet()){
                    if(entry.getKey().getID() == id){
                        fd = entry.getKey();
                    }
                }

                if(fd==null){
                    System.out.println("No such ID");
                    continue;
                }

                System.out.println("Enter Quantity:");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                if(quantity<=0){
                    System.out.println("Invalid Quantity");
                    continue;
                }

                cart.put(fd,quantity);
                System.out.println("Modified Item!");
            }
            else if(choice2==3){
                printDashes();

                System.out.println("Your Cart:\n");
                for(Map.Entry<Food, Integer> entry : cart.entrySet()){
                    System.out.println(entry.getKey().getID()+"."+ entry.getKey()  + " " + entry.getValue() + "[QTY.]");
                }

                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                Food fd = null;

                for(Map.Entry<Food, Integer> entry : cart.entrySet()){
                    if(entry.getKey().getID() == id){
                        fd = entry.getKey();
                    }
                }

                if(fd==null){
                    System.out.println("No such ID");
                    continue;
                }

                cart.remove(fd);

                System.out.println("Removed Item!");

            }
            else if(choice2==4){
                printDashes();

                int total = 0;

                for(Map.Entry<Food, Integer> entry : cart.entrySet()){
                    total += entry.getValue()*entry.getKey().getPrice();
                }

                System.out.println("Total Price:"+total);
            }
            else if (choice2==5) {

                System.out.println("Enter Payment Method:");
                String paymentMethod = scanner.nextLine();
                System.out.println("Enter Address:");
                String address = scanner.nextLine();

                Map<Food,Integer> cartCopy = new HashMap<>(cart);
                Order order = new Order(cartCopy,address,paymentMethod,"Order Received",name);

                while (true){
                    System.out.println("Enter\n1.If You Have Any Special Requests\n2.If You don't");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();

                    if(choice1==1){
                        System.out.println("Enter Request:");
                        String request = scanner.nextLine();

                        order.setSpecialReq(request);
                        break;
                    }else if(choice1==2){
                        break;
                    }else{
                        System.out.println("Please enter a valid choice");
                    }
                }

                orders.add(order);

                cart.clear();

                return order;
            }
            else if (choice2 == 6) {
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }

        return null;
    }

    public Order orders(ArrayList<Order> orders_real){
        printDashes();

        Scanner scanner = new Scanner(System.in);

        while (true){
            printDashes();

            System.out.println("Enter\n1.To View Order Status \n2.To Cancel Order\n3.To Re-Order\n4.To Go Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice==3 || choice == 1){
                printDashes();
                System.out.println("Your Orders:");
                int i = 1;
                for(Order o:orders){
                    System.out.println(i+"."+o);
                }

                if(choice==3){
                    System.out.println("Enter number of order you want to reorder:");

                    int num = scanner.nextInt();
                    scanner.nextLine();

                    if(num<1 || num>orders.size()){
                        System.out.println("Invalid Number");
                        continue;
                    }

                    Order o = orders.get(num-1);
                    o.setStatus("Order Received");
                    orders.add(o);
                    System.out.println("Re-Ordered!");
                    return o;
                }
            }
            else if(choice == 2){
                printDashes();
                System.out.println("Your Orders:");
                int i = 1;
                for(Order o:orders){
                    System.out.println(i+"."+o);
                    i++;
                }

                System.out.println("Enter Number of order you want to cancel:");
                int num = scanner.nextInt();
                scanner.nextLine();

                if(num<1 || num>orders.size()){
                    System.out.println("Invalid choice");
                    continue;
                }

                if(orders.get(num-1).getStatus().equals("Order Received")){
                    Order o = orders.get(num-1);
                    orders_real.remove(o);
                    orders.remove(num-1);

                    System.out.println("Cancelled Order!");
                }else{
                    System.out.println("Too Late!");
                }
            }else if(choice==4){
                break;
            }else{
                printDashes();
                System.out.println("Invalid Choice");
            }
        }

        return null;
    }

    public void review(ArrayList<Food> menu){
        printDashes();

        Scanner scanner = new Scanner(System.in);

        while (true){
            printDashes();

            System.out.println("Press\n1.To Leave Review For An Item You ordered\n2.To View Reviews\n3.To Go Back");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice==1){
                HashSet<String> uniqueValues = new HashSet<>();
                for(Order o:orders){
                    for(Map.Entry<Food, Integer> entry : o.getCart().entrySet()){
                        uniqueValues.add(entry.getKey().getName());
                    }
                }

                ArrayList<String> foods = new ArrayList<>(uniqueValues);

                System.out.println("Items You've ordered:");
                int i = 1;
                for(String str:foods){
                    System.out.println(i+"."+str);
                    i++;
                }

                System.out.println("Enter Number of item you want to review:");
                int num = scanner.nextInt();
                scanner.nextLine();
                if(num<1 || num>foods.size()){
                    System.out.println("Invalid choice");
                    continue;
                }

                System.out.println("Enter Review [1-5]:");
                int stars = scanner.nextInt();
                scanner.nextLine();

                if(stars<1 || stars>5){
                    System.out.println("Invalid choice");
                    continue;
                }

                System.out.println("Enter Review Body:");
                String body = scanner.nextLine();

                Review review = new Review(body,stars,name);

                for(Food f:menu){
                    if(Objects.equals(f.getName(), foods.get(num - 1))){
                        f.addReview(review);
                    }
                }

                System.out.println("Review Added!");
            }
            else if(choice == 2){
                printDashes();

                System.out.println("Enter food name:");
                String foodName = scanner.nextLine();

                Food food = null;
                for(Food f:menu){
                    if(Objects.equals(f.getName(), foodName)){
                        food = f;
                        break;
                    }
                }

                if(food==null){
                    System.out.println("Invalid Name");
                    continue;
                }

                System.out.println("Reviews:");
                for(Review r:food.getReviews()){
                    System.out.println("Rating:"+r.getRating());
                    System.out.println(r.getBody());
                    System.out.println("-"+r.getAuthor());
                }
            } else if (choice == 3) {
                break;
            }else{
                System.out.println("Invalid Choice");
            }
        }
    }
}
