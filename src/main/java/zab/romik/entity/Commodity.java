package zab.romik.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ToString
@EqualsAndHashCode
@Entity
public class Commodity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String gender;
    @Getter
    @Setter
    private BigDecimal price;
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @OneToMany(mappedBy = "commodity", cascade = CascadeType.REMOVE)
    private List<Orders_Commodity> orders_Commodity = new ArrayList<Orders_Commodity>();
    @Getter
    @Setter
    @OneToMany(mappedBy = "commodity", cascade = CascadeType.REMOVE)
    private List<ProductToProperty> productToProperties = new ArrayList<ProductToProperty>();
    @Getter
    @Setter
    @ManyToOne
    private Categories categories;
    @Getter
    @Setter
    @ManyToOne
    private Country country;

    public Commodity() {
    }

    public Commodity(final String name, final BigDecimal price) {
        super();
        this.name = name;
        this.price = price;
    }
}
