package zab.romik.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Entity
public class Categories {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    private int parrentId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    @OneToMany(mappedBy = "categories", cascade = CascadeType.REMOVE)
    private List<Commodity> commodity = new ArrayList<Commodity>();

    public Categories() {
    }

    public Categories(int parrentId, String name) {
        this.parrentId = parrentId;
        this.name = name;
    }
}

