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

public class ManagerScene {
    Stage stage;
    Scene scene;
    LoginScene loginScene;
    public ManagerScene(Stage stage){
        this.stage = stage;
    }
    public void prepareScene(){
        GridPane grid = new GridPane();
        scene = new Scene(grid, 1000, 400);
        Label titleLabel = new Label("\tWelcome Manager\nThese are Today's Reservations\n");
        grid.add(titleLabel, 2, 0);
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        Label reservations = new Label();
        Label totalincomeLabel = new Label();
        Button Logout = new Button("LOGOUT");
        grid.add(Logout,0,0);
        grid.add(reservations,2,2);
        grid.add(totalincomeLabel,2,3);

        StringBuilder sb = new StringBuilder();
        double totalIncome=0;
        for (Reservation reservation : RestaurantManager.restaurant.getReservations().getReservations()) {
            sb.append("Customer: ").append(reservation.getClient_name()).append("\tTable Number: ").append(reservation.getTable_number())
                    .append("\tOrdered Dishes: ").append(reservation.getDishes()).append("\tBill: ").append(reservation.getTotal_price()).append('\n');
            totalIncome=totalIncome+reservation.getTotal_price();
        }
        reservations.setText(sb.toString());
        totalincomeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        totalincomeLabel.setText("Your Total Income is "+(totalIncome));

Logout.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        stage.setScene(LoginScene.getScene());
    }
});

    }
    public Scene getScene(){
        return this.scene;
    }
    public void setLoginScene(LoginScene loginScene) {
        this.loginScene = loginScene;
    }


}
