package Resturant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {
    @XmlElement(name = "users")
    private Users users = null;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlElement(name = "tables")
    private Tables tables = null;

    public Tables getTables() {
        return tables;
    }

    public void setTables(Tables tables) {
        this.tables = tables;
    }
    @XmlElement(name = "dishes")
    private Dishes dishes = null;

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    @XmlElement(name = "reservations")
    private Reservations reservations = null;

    public  Reservations getReservations() {
        if (this.reservations==null){
            this.reservations=new Reservations();
        }

        return this.reservations;
    }

    public void setReservations(Reservations reservations) {
        this.reservations = reservations;
    }
}


