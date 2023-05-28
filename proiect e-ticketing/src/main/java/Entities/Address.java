package Entities;


public class Address extends GenericEntity {
    private String street;
    private int number;
    private String zipCode;
    private String town;
    private String country;

//    @OneToMany(mappedBy = "address")
//    private Set<Customer> customers;
//
//    @OneToMany(mappedBy = "address")
//    private Set<Venue> venues;

    public Address(){}

    public Address(int id, String street, int number, String zipCode, String town, String country)
    {
        super(id);
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.town = town;
        this.country = country;
    }

    public String getStreet()
    {
        return this.street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public int getNumber()
    {
        return this.number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String getZipCode()
    {
        return this.zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getTown()
    {
        return this.town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }

    public String getCountry()
    {
        return this.country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Street: " + this.street + '\n' + "Number: " + this.number + '\n' + "ZipCode: " +
                this.zipCode + '\n' + "Town: " + this.town + '\n' + "Country: " + this.country;
    }

}
