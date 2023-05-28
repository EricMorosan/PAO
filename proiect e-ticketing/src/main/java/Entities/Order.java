package Entities;

import java.util.*;
public class Order extends GenericEntity {
    private Date orderDate;


    private int customerid;

    public Order(){}
    public Order(int id, Date orderDate, int customerid) {
        super(id);
        this.orderDate = orderDate;
        this.customerid = customerid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    @Override
    public String toString() {
        return "Date: " + this.orderDate + "customerid: " + this.customerid;
    }

    //    @OneToMany(mappedBy = "order")
//    private Set<OrderTicket> orderTickets;
}
