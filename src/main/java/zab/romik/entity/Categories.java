package zab.romik.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int parrentId;
    private String name;
    @OneToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Commodity> commodity = new ArrayList<Commodity>();

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

    public int getParrentId() {
        return parrentId;
    }

    public void setParrentId(int parrentId) {
        this.parrentId = parrentId;
    }

    @Override
    public String toString() {
        return "Categories [id=" + id + ", name=" + name + ", parrentId=" + parrentId + "]";
    }
}

