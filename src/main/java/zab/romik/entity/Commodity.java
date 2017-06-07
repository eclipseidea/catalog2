package zab.romik.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import zab.romik.enums.CommodityGender;
import zab.romik.forms.CommodityForm;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@ToString
@EqualsAndHashCode
@Entity
public class Commodity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;

    /**
     * Рекомендуемый пол для покупателя товара
     */
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private CommodityGender gender = CommodityGender.UNIVERSAL;

    @Getter
    @Setter
    private BigDecimal price;
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    @OneToMany(mappedBy = "commodity", cascade = CascadeType.REMOVE)
    private List<Orders_Commodity> orders_Commodity = new ArrayList<Orders_Commodity>();
    @Getter
    @Setter
    @OneToMany(mappedBy = "commodity", cascade = CascadeType.REMOVE)
    private List<ProductToProperty> productToProperties = new ArrayList<ProductToProperty>();

    @Getter
    @Setter
    @OneToOne
    private Categories categories;

    @Getter
    @Setter
    @ManyToOne
    private Country country;

    public Commodity() {
    }

    public Commodity(final String name, final BigDecimal price) {
        super();
        this.name = name;
        this.price = price;
    }

    /**
     * Статический метод генерации (как рекомендуется в книге Effective Java),
     * заполняет сущность Commodity из формы пользователя.
     *
     * @param form       Форма из которой будет заполняться сущность
     * @param categories Категория которую надо заинжектить в товар
     * @return Заполненная сущность
     */
    public static Commodity valueOf(final CommodityForm form, final Categories categories) {
        final Commodity commodity = new Commodity(form.getName(), form.getPrice());

        commodity.setAge(form.getRecommendationAge());
        commodity.setDescription(form.getDescription());
        commodity.setQuantity(form.getQuantity());
        commodity.setCategories(categories);
        commodity.setGender(form.getGender());

        return commodity;
    }
}
