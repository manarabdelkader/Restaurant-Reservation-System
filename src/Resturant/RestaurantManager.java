package Resturant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class RestaurantManager {

    public static Restaurant restaurant;
    public static String clientName;


    public static void setUser(String clientname) {
        RestaurantManager.clientName = clientname;
    }

    public static String getUser() {
        return clientName;
    }

    public static void getrestaurant() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        RestaurantManager.restaurant=((Restaurant)unmarshaller.unmarshal(new File("input.xml")));
    }

    public static void saverestaurant() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(RestaurantManager.restaurant,new File("input.xml"));
    }


}
