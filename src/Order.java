
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

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
            price += entry.getValue()*entry.getKey().getPrice();
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

    public void setStatus(String status){
        this.status = status;
    }

    public Map<Food, Integer> getCart(){
        return cart;
    }

    @Override
    public String toString() {
        return dtf.format(orderDate) + " ₹" + price + " " + deliveryDetail + "[address] " + paymentDetail + "[payment] " +status + "[status] " + orderedBy + "[ordered by]";
    }
}
