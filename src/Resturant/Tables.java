package Resturant;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tables {
    @XmlElement(name = "table")
    private List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> users) {
        this.tables = tables;
    }

    public int isAvailable(boolean Type, int numberofseats) throws JAXBException {
        int tablenum=0;
        for (Table table : RestaurantManager.restaurant.getTables().getTables()) {
            if (numberofseats == table.getNumber_of_seats() && Type==table.getSmoking()) {
                tablenum= table.getNumber();
                for(Reservation reservation: RestaurantManager.restaurant.getReservations().getReservations()){
                    if(tablenum==reservation.getTable_number())
                        tablenum=0;
                }
            }
        }
        return tablenum;
    }
}
