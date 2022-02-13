package Resturant;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CookerScene {

    Stage stage;
    Scene scene;
    LoginScene loginScene;


    public CookerScene(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {
        GridPane grid = new GridPane();
        scene = new Scene(grid, 1000, 400);
        Label titleLabel = new Label("\tWelcome Cooker\nThese are the Ordered Dishes for Today\n");
        grid.add(titleLabel, 2, 0);
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label orders = new Label();
        Button Logout = new Button("LOGOUT");
        grid.add(Logout,0,0);
        grid.add(orders,2,2);
        StringBuilder sb = new StringBuilder();
        for (Reservation reservation : RestaurantManager.restaurant.getReservations().getReservations()) {
            sb.append("Table Number: ").append(reservation.getTable_number()).append("\tDishes:  ").append(reservation.getDishes()).append('\n');
        }
        orders.setText(sb.toString());

        Logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(LoginScene.getScene());
            }
        });
    }

    public Scene getScene() {
        return scene;
    }

    public void setLoginScene(LoginScene loginScene) {
        this.loginScene = loginScene;
    }
}

