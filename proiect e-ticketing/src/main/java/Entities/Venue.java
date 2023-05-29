package Entities;



public class Venue extends GenericEntity {
    private String name;
    private String type;
    private int capacity;
    private int addressid;

    public Venue() {
    }

    public Venue(int id, String name, String type, int capacity, int addressid) {
        super(id);
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.addressid = addressid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n Capacity: " + this.capacity;
    }
//    @OneToMany(mappedBy = "venue")
//    private Set<Event> events;
}
