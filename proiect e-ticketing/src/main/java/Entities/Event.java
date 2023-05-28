package Entities;

import java.util.*;

public class Event extends GenericEntity {
    private String Name;
    private String type;
    private Date startDate;
    private Date endDate;

    public Event(){}
    public Event(int id, String name, String type, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.Name + "\n start date: " + this.startDate + " \n end date: " + this.endDate;
    }

    //    @OneToMany(mappedBy = "event")
//    private Set<Ticket> tickets;
}
