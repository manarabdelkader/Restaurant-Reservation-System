package Resturant;

public class Login {

    public int loginValidation(String username, String password)  {


        int validate = 0;
        for (User user : RestaurantManager.restaurant.getUsers().getUsers()) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {

                if ("Client".equals(user.getRole()))
                validate = 2;

                if ("Manager".equals(user.getRole())){
                    validate = 3;}

                if ("Waiter".equals(user.getRole())){
                    validate = 4;}

                if ("Cooker".equals(user.getRole())){
                    validate = 5;}
            }
        }

        return validate;
    }

    public static String getName(String  username) {

        for (User user : RestaurantManager.restaurant.getUsers().getUsers()){
            if(username.equals(user.getUsername())){
                return user.getName();
            }
        }
        return username;
    }
}
