package zab.romik.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "properties", cascade = CascadeType.REMOVE)
    private List<Valuess> value = new ArrayList<Valuess>();
    private String title;

    public Properties() {
    }

    public Properties(String title) {
        super();
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Valuess> getValue() {
        return value;
    }

    public void setValue(List<Valuess> value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "PropertiesDao [id=" + id + ", title=" + title + "]";
    }

}
