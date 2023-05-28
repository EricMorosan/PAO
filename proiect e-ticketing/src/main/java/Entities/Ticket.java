package Entities;



public class Ticket extends GenericEntity {
    private String description;
    private int price;

    private int eventid;

    public Ticket (){}
    public Ticket(int id, String description, int price, int eventid) {
        super(id);
        this.description = description;
        this.price = price;
        this.eventid = eventid;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getEventid() {
        return eventid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    @Override
    public String toString() {
        return "Description: " + this.description + "\n price: " + this.price;
    }
    //    @OneToMany(mappedBy = "ticket")
//    private Set<OrderTicket> orderTickets;
}
