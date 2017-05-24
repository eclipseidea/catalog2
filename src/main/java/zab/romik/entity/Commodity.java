package zab.romik.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String gender;
    private BigDecimal price;
    private int quontity;
    private String description;
    @OneToMany(mappedBy = "commodity", cascade = CascadeType.REMOVE)
    private List<Orders_Commodity> orders_Commodity = new ArrayList<Orders_Commodity>();
    @OneToMany(mappedBy = "commodity", cascade = CascadeType.REMOVE)
    private List<ProductToProperty> productToProperties = new ArrayList<ProductToProperty>();
    @ManyToOne
    private Categories categories;
    @ManyToOne
    private Counrty country;

    public Commodity() {
    }

    public Commodity(String name, BigDecimal price, int quontity, int age, String gender, String description, Categories categories) {
        super();
        this.name = name;
        this.price = price;
        this.quontity = quontity;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.categories = categories;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Counrty getCountry() {

        return country;
    }

    public void setCountry(Counrty country) {
        this.country = country;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public int getQuontity() {
        return quontity;
    }

    public void setQuontity(int quontity) {
        this.quontity = quontity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Orders_Commodity> getOrders_Commodity() {
        return orders_Commodity;
    }

    public void setOrders_Commodity(List<Orders_Commodity> orders_Commodity) {
        this.orders_Commodity = orders_Commodity;
    }

    @Override
    public String toString() {
        return "Commodity [name=" + name + ", age=" + age + ", gender=" + gender + ", price=" + price
                + ", quontity=" + quontity + ", description=" + description + "]";
    }
}
