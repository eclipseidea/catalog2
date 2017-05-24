package zab.romik.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "user")
    private Set<Visitor> visitor = new HashSet<Visitor>();
    private String name;
    private String email;
    private String country;
    private String region;
    private String city;
    private String street;
    private String numberOfPone;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    public User() {
    }


    public User(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public Set<Visitor> getVisitor() {
        return visitor;
    }

    public void setVisitor(Set<Visitor> visitor) {
        this.visitor = visitor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberOfPone() {
        return numberOfPone;
    }

    public void setNumberOfPone(String numberOfPone) {
        this.numberOfPone = numberOfPone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", country=" + country + ", region=" + region
                + ", city=" + city + ", street=" + street + ", numberOfPone=" + numberOfPone + "]";
    }
}
