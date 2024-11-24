
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

// time price address payment-method status orderedBy

public class Order {
    private Map<Food, Integer> cart = new HashMap<>();
    private String deliveryDetail;
    private String paymentDetail;
    private String status;
    private LocalDateTime orderDate;
    private String orderedBy;

    private boolean req = false;
    private String specialReq;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private int price;

    public Order(Map<Food,Integer> cart,String deliveryDetail, String paymentDetail, String status,String orderedBy) {
        this.cart = cart;
        this.deliveryDetail = deliveryDetail;
        this.paymentDetail = paymentDetail;
        this.status = status;
        this.orderedBy = orderedBy;

        orderDate = LocalDateTime.now();

        for(Map.Entry<Food, Integer> entry : cart.entrySet()) {
            if(entry.getKey()!=null)price += entry.getValue()*entry.getKey().getPrice();
        }
    }

    public void setDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void saveInFile(){
        String output = "";
        output += orderedBy + ",";
        output += deliveryDetail + "," + paymentDetail + "," + status + ",";
        output += req + "," + specialReq + "," + price + "," + orderDate.toString() + ",";

        String cartOut = "";
        for(Map.Entry<Food, Integer> entry : cart.entrySet()) {
            Food food = entry.getKey();
            int quantity = entry.getValue();
            cartOut += food.getID()+"-"+quantity+",";
        }

        output += "Cart" + "," + cartOut + "\n";

        FileWriter out = null;
        try{
            out = new FileWriter("orders.txt",true);
            out.write(output);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(out != null){
                try{
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isReq() {
        return req;
    }

    public int getPrice(){
        return price;
    }

    public void setSpecialReq(String specialReq) {
        req = true;
        this.specialReq = specialReq;
    }

    public String getSpecialReq() {
        return specialReq;
    }

    public String getStatus(){
        return status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getPaymentMethod(){
        return paymentDetail;
    }

    public String getAddress() {
        return deliveryDetail;
    }

    public String getOrderedBy(){
        return orderedBy;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Map<Food, Integer> getCart(){
        return cart;
    }

    @Override
    public String toString() {
        return dtf.format(orderDate) + " ₹" + price + " [Price] " + deliveryDetail + "[address] " + paymentDetail + "[payment Method] " +status + "[status] " + orderedBy + "[ordered by]";
    }
}
