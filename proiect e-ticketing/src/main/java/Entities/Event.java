package Entities;

import java.time.LocalDate;
import java.util.*;

public class Event extends GenericEntity {
    private String Name;
    private String type;
    private String startDate;
    private String endDate;

    public Event(){}
    public Event(int id, String name, String type, String startDate, String endDate) {
        super(id);
        this.Name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return type;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.Name + "\n start date: " + this.startDate + " \n end date: " + this.endDate;
    }

    //    @OneToMany(mappedBy = "event")
//    private Set<Ticket> tickets;
}
