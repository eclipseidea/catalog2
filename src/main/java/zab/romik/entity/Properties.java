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
public class Properties {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    @OneToMany(mappedBy = "properties", cascade = CascadeType.REMOVE)
    private List<Value> value = new ArrayList<Value>();
    @Getter
    @Setter
    private String title;

    public Properties() {
    }

    public Properties(final String title) {
        super();
        this.title = title;
    }
}
