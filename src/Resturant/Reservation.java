package Resturant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {
    @XmlElement(name = "table_number")
    private int table_number;
    @XmlElement(name = "client_name")
    private String client_name;
    @XmlElement(name = "dishes")
    private String dishes;
    @XmlElement(name = "total_price")
    private double total_price;

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getTable_number() {
        return table_number;
    }

    public void setTable_number(int table_number) {
        this.table_number = table_number;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }



    public void reservation(String name, int tableNumber, double totalPrice, String dishes) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        Reservation reservation = new Reservation();
        reservation.setClient_name(name);
        reservation.setTable_number(tableNumber);
        reservation.setDishes(dishes);
        reservation.setTotal_price(totalPrice);
        List<Reservation> reservationlist = RestaurantManager.restaurant.getReservations().getReservations();
        reservationlist.add(reservation);
        RestaurantManager.saverestaurant();
    }
}
