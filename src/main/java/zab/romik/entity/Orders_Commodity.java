package zab.romik.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class Orders_Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quontity;
    private BigDecimal costOfCommodity;
    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Commodity commodity;

    public Orders_Commodity() {
    }

    public Orders_Commodity(Long id, int quontity, BigDecimal costOfCommodity, Orders orders, Commodity commodity) {
        super();
        this.id = id;
        this.quontity = quontity;
        this.costOfCommodity = costOfCommodity;
        this.orders = orders;
        this.commodity = commodity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuontity() {
        return quontity;
    }

    public void setQuontity(int quontity) {
        this.quontity = quontity;
    }

    public BigDecimal getCostOfCommodity() {
        return costOfCommodity;
    }

    public void setCostOfCommodity(BigDecimal costOfCommodity) {
        this.costOfCommodity = costOfCommodity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    @Override
    public String toString() {
        return "Orders_Commodity [id=" + id + ", quontity=" + quontity + ", costOfCommodity=" + costOfCommodity
                + ", orders=" + orders + ", commodity=" + commodity + "]";
    }
}
