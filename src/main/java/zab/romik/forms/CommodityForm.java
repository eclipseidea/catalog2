package zab.romik.forms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import zab.romik.entity.Country;
import zab.romik.enums.CommodityGender;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Форма для создания товаров, это традиционный подход к
 * переносимости данных внутри приложения на Spring
 *
 * @since 0.0.1
 */
@ToString
@EqualsAndHashCode
public class CommodityForm implements Serializable {

    /**
     * Имя товара
     */
    @NotEmpty
    @Length(min = 2, max = 255)
    @Getter
    @Setter
    private String name;

    /**
     * Цена товара, используется BigDecimal потому
     * что он больше подходит для хранения цен, он
     * более точный
     */
    @NotNull
    @Getter
    @Setter
    private BigDecimal price;

    /**
     * Описание товара
     */
    @Getter
    @Setter
    private String description;

    /**
     * Рекомендация по возрасту, стандартный 3 года
     */
    @Min(1)
    @Getter
    @Setter
    private int recommendationAge = 3;

    /**
     * Количество товара, по-умолчанию 10
     */
    @Min(1)
    @Getter
    @Setter
    private int quantity = 10;

    /**
     * ID категории, используется упакованный тип
     * потому что его можно проверить на NULL, нельзя в данной
     * ситуации использовать примитив потому что он по-умолчанию
     * содержит значение 0, а 0 может быть ID'шником категории и в
     * итоге получится нежелательный результат
     */
    @NotNull
    @Getter
    @Setter
    private Long categoryId;

    /**
     * Рекомендуемый пол для товара
     */
    @NotNull
    @Getter
    @Setter
    private CommodityGender gender;


    @Getter
    @Setter
    private Country country;


}
