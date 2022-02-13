package Resturant;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;


public class ClientScene {
    Stage stage;
    Scene scene;
    Tables availableTable;
    Dishes dishes;
    LoginScene loginScene;
    Login validation;
    Reservation reservation;
    private int tableNumber;
    private int getTableNumber() { return tableNumber; }
    private void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }

    public ClientScene(Stage stage){
        this.stage = stage;
    }

    public void prepareScene()  {
        validation = new Login();
        availableTable =new Tables();
        dishes = new Dishes();
        GridPane grid = new GridPane();
        //Button Logout = new Button("LOGOUT");
        //grid.add(Logout,0,0);
        Label numberLabel = new Label("Enter number of seats:");
        Label smokingLabel = new Label("Enter TRUE(smoking)\nor FALSE(non-smoking):");
        TextField numberField = new TextField();
        TextField smokingField = new TextField();
        Label menu = new Label();
        TextField dish = new TextField();
        Button add = new Button("Add dish");
        Button submit= new Button("Submit");
        Button confirmOrderButton= new Button("Click to Confirm Your Reservation");
        Label confirmOrderLabel = new Label();
        Label priceLabel = new Label();
        Label availableLabel = new Label();
        grid.add(numberLabel,1,1);
        grid.add(smokingLabel,1,2 );
        grid.add(numberField, 2,1);
        grid.add(smokingField, 2,2);
        grid.add(submit,2,4 );
        grid.add(availableLabel,3,5 );
        availableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        grid.add(menu,1,7 );
        grid.add(priceLabel,1,10 );
        scene = new Scene(grid,1100,500);


       // Logout.setOnAction(new EventHandler<ActionEvent>() {
        //   @Override
        //   public void handle(ActionEvent event) {
        //      stage.setScene(LoginScene.getScene());
        //  }
       // });

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean Type = Boolean.parseBoolean(smokingField.getText());
                int numberofseats = Integer.parseInt((numberField.getText()));
                int tablenum=0;
                try {
                    tablenum = availableTable.isAvailable(Type, numberofseats);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                if (tablenum == 0) {
                    availableLabel.setText("NO AVAILABLE TABLE");
                } else {
                    setTableNumber(tablenum);
                    availableLabel.setText("AVAILABLE TABLE");
                    grid.add(add, 2, 9);
                    grid.add(dish, 1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (Dish dish : RestaurantManager.restaurant.getDishes().getDishes()) {
                        sb.append("Name: ").append(dish.getName()).append("\tType: ").append(dish.getType()).append("\tPrice: ").append(dish.getPrice()).append('\n');
                    }
                    menu.setText(sb.toString());
                    grid.add(confirmOrderButton,4,10 );

                }
            }
        });

        final String[] Dishes = {""};
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String dishName = dish.getText();
                int price;
                String type;
                for (Dish dish : RestaurantManager.restaurant.getDishes().getDishes()) {
                    if (dishName.equals(dish.getName())) {
                        price = dish.getPrice();
                        type = dish.getType();
                        dishName = dish.getName();
                        dishes.updateTotalPrice(price, type);
                        Dishes[0] = Dishes[0].concat(dishName +",");
                        priceLabel.setText("BILL="+dishes.getTotalPrice());
                    }
                }
            }
        });


        confirmOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("confirm");
                reservation = new Reservation();
                grid.add(confirmOrderLabel,4,11);
                confirmOrderLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                confirmOrderLabel.setText("Reservation confirmed \nYour table number is " + getTableNumber()+"\nTotal bill "+ dishes.getTotalPrice()
                        +" including taxes\nThank you for choosing our Restaurant!");

                for (Reservation reservation : RestaurantManager.restaurant.getReservations().getReservations()){
                    System.out.println(reservation.getTotal_price() + reservation.getClient_name());
                }

                try {
                    reservation.reservation(RestaurantManager.getUser(),getTableNumber() ,dishes.getTotalPrice(), Dishes[0]);

                } catch (JAXBException e) {
                    System.out.println("catch");
                    e.printStackTrace();
                }
                for (Reservation reservation : RestaurantManager.restaurant.getReservations().getReservations()){
                    System.out.println(reservation.getTotal_price() + reservation.getClient_name());}
            }
        });


    }

    public Scene getScene(){
        return scene;
    }

    public void setLoginScene(LoginScene loginScene) {
        this.loginScene = loginScene;
    }
}
