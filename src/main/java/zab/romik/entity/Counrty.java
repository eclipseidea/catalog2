package zab.romik.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Counrty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "country", cascade = CascadeType.REMOVE)
    private List<Commodity> commodity;

    public Counrty() {

    }

    public Counrty(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Commodity> getCommodity() {
        return commodity;
    }

    public void setCommodity(List<Commodity> commodity) {
        this.commodity = commodity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Counrty [id=" + id + ", name=" + name + "]";
    }
}

