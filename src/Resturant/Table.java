package Resturant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {
    @XmlElement(name = "number")
    private int number;
    @XmlElement(name = "number_of_seats")
    private int number_of_seats;
    @XmlElement(name = "smoking")
    private boolean smoking;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

}