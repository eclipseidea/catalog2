package zab.romik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zab.romik.service.PropertiesService;

import java.util.Properties;

import static java.util.Objects.requireNonNull;

/**
 * Рест контроллер для того чтбы получать значения свойств для
 * динамических формы которые работают со свойствами
 *
 * @since 0.0.1
 */
@RestController
@RequestMapping("/properties")
public class Api {

    /**
     * Сервис для работы со свойствами
     */
    private final PropertiesService propertiesService;

    /**
     * Конструктор для внедрения зависимостей
     *
     * @param propertiesService Сервис для работы со свойствами, не должен быть null
     */
    @Autowired
    public Api(PropertiesService propertiesService) {
        this.propertiesService = requireNonNull(propertiesService, "Properties service must be not null!");
    }

    /**
     * Загружает свойство из базы данных по ID
     *
     * @param id ID свойства
     * @return найденное свойство
     */
    @GetMapping("/{id}/values")
    private Properties findById(@PathVariable("id") final long id) {
        return propertiesService.findOne(id);
    }
}