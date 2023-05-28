package Entities;

public class Customer extends GenericEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String type;

    private int addressid;
    public Customer(){}

    public Customer(int id, String firstName, String lastName, String email, String phone, String type, int addressid) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.addressid = addressid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName + "\n email: " + this.email + "\n phone: " + this.phone;
    }


    //    @OneToMany(mappedBy = "customer")
//    private Set<Order> orders;
}
