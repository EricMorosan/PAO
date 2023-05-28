package Entities;

public class OrderTicket extends GenericEntity{

    private int quantity;

    private int orderid;

    private int ticketid;

    public OrderTicket(){}

    public OrderTicket(int id, int quantity, int orderid, int ticketid) {
        super(id);
        this.quantity = quantity;
        this.orderid = orderid;
        this.ticketid = ticketid;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrderid() {
        return orderid;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }


    @Override
    public String toString() {
        return null;
    }

}
