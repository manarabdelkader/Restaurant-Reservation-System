package Resturant;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginScene {

      static Scene scene;
      Login validation;
      ClientScene clientScene;
      ManagerScene managerScene;
      WaiterScene waiterScene;
      CookerScene cookerScene;
      Stage stage;
      public LoginScene(Stage stage){
          this.stage = stage;
      }

      public void prepareScene() {
        validation = new Login();
          GridPane grid = new GridPane();
          scene = new Scene(grid,800,300);
          Label welcomeLabel = new Label("WELCOME TO THE RESTAURANT");
          welcomeLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
          grid.add(welcomeLabel,2,0);
         Label usernameLabel = new Label("Username: ");
         Label passwordLabel = new Label("Password: ");
         TextField usernameField = new TextField();
         PasswordField passwordField = new PasswordField();
         Button submit = new Button("Submit");
         Button clear = new Button("clear");
         Label validationlabel = new Label();
         grid.add(usernameLabel,0,1);
         grid.add(passwordLabel,0,2 );
         grid.add(usernameField, 1,1);
         grid.add(passwordField, 1,2);
         grid.add(submit,1,3);
         grid.add(clear,1,4);
         grid.add(validationlabel,2,5 );
         validationlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));


          clear.setOnAction(new EventHandler<ActionEvent>() {
              @Override
              public void handle(ActionEvent event) {
                  usernameField.setText("");
                  passwordField.setText("");
              }
          });
          submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                int valid = 0;
                 String Name=null;
                    valid = validation.loginValidation(username, password);
                    RestaurantManager.setUser(validation.getName(username));

                    if (valid == 2) {
                        stage.setScene(clientScene.getScene());
                         }
                    else if (valid == 3) {
                        stage.setScene(managerScene.getScene());

                    } else if (valid == 4) {
                        stage.setScene(waiterScene.getScene());

                    } else if (valid == 5) {
                        stage.setScene(cookerScene.getScene());

                    } else {
                        validationlabel.setText("NOT found");
                    }
            }
        });
    }

    public static Scene getScene(){
          return scene;
    }
    public void setClientScene(ClientScene clientScene) {
        this.clientScene = clientScene;
    }
    public void setManagerScene(ManagerScene managerScene) {
        this.managerScene = managerScene;
    }
    public void setWaiterScene(WaiterScene waiterScene) {
        this.waiterScene = waiterScene;
    }
    public void setCookerScene(CookerScene cookerScene) {
        this.cookerScene = cookerScene;
    }

}
