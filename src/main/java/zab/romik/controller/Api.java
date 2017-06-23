package zab.romik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zab.romik.Routes;
import zab.romik.entity.Properties;
import zab.romik.entity.Value;
import zab.romik.exceptions.RestResourceNotFoundException;
import zab.romik.service.PropertiesService;

import zab.romik.service.ValueService;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Рест контроллер для того чтбы получать значения свойств для
 * динамических формы которые работают со свойствами
 *
 * @since 0.0.1
 *
 */
@RestController
@RequestMapping(Routes.Properties.PROPERTIES_LIST)
public class Api {

    /**
     * Сервис для работы со свойствами
     */
    private final PropertiesService propertiesService;

    private final ValueService valueService;


    /**
     * Конструктор для внедрения зависимостей
     *
     * @param propertiesService Сервис для работы со свойствами, не должен быть null
     * @param valueService
     */
    @Autowired
    public Api(PropertiesService propertiesService, ValueService valueService) {
        this.propertiesService = requireNonNull(propertiesService, "Properties service must be not null!");
        this.valueService = valueService;
    }

    /**
     * Загружает свойство из базы данных по ID
     *
     * @param id ID свойства
     * @return найденное свойство
     */
    @GetMapping(Routes.Properties.PROPERTY_VALUES)
    private List<Value> findById(@PathVariable("id") final long id) {
        Properties property = propertiesService.findOne(id);
        if (Objects.isNull(property)) {
            throw new RestResourceNotFoundException();
        }
        return property.getValue();
    }
}