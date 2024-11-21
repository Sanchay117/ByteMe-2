
public class Review {
    private String body;
    private int rating; // out of 5
    private String author;

    public Review(String body, int rating, String author) {
        this.body = body;
        this.rating = rating;
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public int getRating() {
        return rating;
    }

    public String getAuthor() {
        return author;
    }
}
