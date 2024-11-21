
import java.util.ArrayList;

public class Food {
    private String name;
    private int price;
    private int ID;
    private String category;
    private boolean available;
    private final ArrayList<Review> reviews = new ArrayList<>();

    public Food(String name, int price, int ID, String category, boolean available) {
        this.name = name;
        this.price = price;
        this.ID = ID;
        this.category = category;
        this.available = available;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(int available) {
        if(available == 1) this.available = true;
        else this.available = false;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    @Override
    public String toString(){
        if(available){
            return name + " " + Integer.toString(price) + "[Price]  Available [" + category + "]"  ;
        }

        return name + " " + Integer.toString(price) + "[Price]  Unavailable [" + category + "]"  ;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }
}

