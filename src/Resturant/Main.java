package Resturant;

        import javafx.application.Application;
        import javafx.stage.Stage;

        import javax.xml.bind.JAXBException;


public class Main extends Application {

    public static void main(String[] args) throws JAXBException {
        RestaurantManager.getrestaurant();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Restaurant");
        LoginScene loginScene = new LoginScene(primaryStage);
        ClientScene clientScene = new ClientScene(primaryStage);
        ManagerScene managerScene = new ManagerScene(primaryStage);
        WaiterScene waiterScene = new WaiterScene(primaryStage);
        CookerScene cookerScene = new CookerScene(primaryStage);
        loginScene.prepareScene();
        clientScene.prepareScene();
        managerScene.prepareScene();
        waiterScene.prepareScene();
        cookerScene.prepareScene();
        loginScene.setClientScene(clientScene);
        clientScene.setLoginScene(loginScene);
        loginScene.setManagerScene(managerScene);
        managerScene.setLoginScene(loginScene);
        loginScene.setWaiterScene(waiterScene);
        waiterScene.setLoginScene(loginScene);
        loginScene.setCookerScene(cookerScene);
        cookerScene.setLoginScene(loginScene);
        primaryStage.setScene(loginScene.getScene());
        primaryStage.show();

    }
}
