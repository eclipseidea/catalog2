package zab.romik.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private OrderState status;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.REMOVE)
    private List<Orders_Commodity> orders_Commodity;
    public Orders() {
    }

    public Orders(LocalDateTime date) {
        super();
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderState getStatus() {
        return status;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }

    public List<Orders_Commodity> getOrders_Commodity() {
        return orders_Commodity;
    }

    public void setOrders_Commodity(List<Orders_Commodity> orders_Commodity) {
        this.orders_Commodity = orders_Commodity;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", date=" + date + ", user=" + user + ", status=" + status + "]";
    }

    public enum OrderState {
        NEW, CONFIRMED, SENT, RECIEVED, PAID
    }
}
