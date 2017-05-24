package zab.romik.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String query;
    @Column(name = "ip", columnDefinition = "char(15)")
    private String ip;
    @ManyToOne
    private User user;
    private LocalDateTime date;

    public Visitor() {
    }

    public Visitor(User user, LocalDateTime date) {
        super();
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Visitor [id=" + id + ", query=" + query + ", ip=" + ip + ", user=" + user + ", date=" + date + "]";
    }
}
