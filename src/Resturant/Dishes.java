package Resturant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {

    @XmlElement(name = "dish")
    private List<Dish> dishes;
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public double TotalPrice;
    public double getTotalPrice() {
        return TotalPrice;
    }
    public void setTotalPrice(int price,double tax) {
        TotalPrice = TotalPrice + ((price*tax)+price);
    }
    public void updateTotalPrice(int price, String type) {
        if (type.equals("appetizer")) {
            setTotalPrice(price,0.1);
        }
        if (type.equals("main_course")) {
            setTotalPrice(price,0.15);
        }
        if (type.equals("desert")) {
            setTotalPrice(price,0.2);
        }
    }
}
