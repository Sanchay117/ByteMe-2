import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class GUI extends Application {
    private Stage primaryStage;
    private Scene mainScene;

    private final Main main = new Main();
    private ArrayList<Food> menu = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        main.prepopulate();
        menu = main.menu;
        orders = main.orders;

        primaryStage.setTitle("Byte Me!");
        primaryStage.setHeight(400);
        primaryStage.setWidth(800);

        Button menuButton = new Button("Menu");
        Button orderButton = new Button("Order");

        menuButton.setOnAction(new MenuEvent());

//        ListView<Food> foodList = new ListView<>();
//        foodList.getItems().addAll(main.menu);
//
//        // Handle item selection and display details
//        foodList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                System.out.println("Selected: " + newValue.getName() + "\nPrice: $" + newValue.getPrice() + "\nAvailability: " + (newValue.isAvailable() ? "In Stock" : "Out of Stock"));
//            }
//        });

        // Set up the layout and scene
        VBox layout = new VBox(10);
        layout.getChildren().add(menuButton);
        layout.getChildren().add(orderButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setTitle("Canteen Menu");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    class MenuEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            ListView<Food> foodList = new ListView<>();
            foodList.getItems().addAll(menu);

            Button backButton = new Button("Back");
            backButton.setOnAction(e -> primaryStage.setScene(mainScene));

            VBox menuLayout = new VBox(10);
            menuLayout.getChildren().addAll(foodList, backButton);

            Scene menuScene = new Scene(menuLayout, 400, 300);
            primaryStage.setScene(menuScene);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
