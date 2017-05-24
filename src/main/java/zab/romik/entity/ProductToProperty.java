package zab.romik.entity;

import javax.persistence.*;

@Entity
public class ProductToProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Properties propertyID;
    @OneToOne(cascade = CascadeType.ALL)
    private Valuess valueID;
    @ManyToOne
    private Commodity commodity;

    public ProductToProperty() {
    }

    public ProductToProperty(Properties propertyID, Valuess valueID, Commodity commodity) {
        super();
        this.propertyID = propertyID;
        this.valueID = valueID;
        this.commodity = commodity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Properties getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Properties propertyID) {
        this.propertyID = propertyID;
    }

    public Valuess getValueID() {
        return valueID;
    }

    public void setValueID(Valuess valueID) {
        this.valueID = valueID;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "ProductToProperty [id=" + id + ", propertyID=" + propertyID + ", valueID=" + valueID + ", commodity="
                + commodity + "]";
    }
}
