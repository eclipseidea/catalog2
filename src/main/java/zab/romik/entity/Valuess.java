package zab.romik.entity;

import javax.persistence.*;

@Entity
public class Valuess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Properties properties;
    private String value;

    public Valuess() {
    }

    public Valuess(Properties properties, String value) {
        super();
        this.properties = properties;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Valuess [id=" + id + ", properties=" + properties + ", value=" + value + "]";
    }
}
