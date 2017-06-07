package zab.romik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zab.romik.entity.Commodity;
import zab.romik.forms.CommodityForm;
import zab.romik.service.CategoriesService;
import zab.romik.service.CommodityService;

import javax.validation.Valid;

@Controller
public class CommodityController {

    /**
     * Имя страницы на которой можно создавать товары
     */
    private static final String CREATE_COMMODITY_VIEW_NAME = "commodity_create";

    /**
     * Роут на котором создаются товары в системе
     */
    private static final String COMMODITY_CREATE_ENDPOINT = "/commodity/create";

    /**
     * Имя атрибута которое содержит в себе форму commodity
     */
    private static final String COMMODITY_MODEL_ATTRIBUTE = "commodity";

    /**
     * Ключ в сессии для сообщения о том, что товар был успешно создан
     */
    private static final String COMMODITY_SUCCESS_CREATE_PRODUCT_KEY = "commoditySuccessCreate";

    /**
     * Сообщение о том, что товар был успешно создан
     */
    private static final String COMMODITY_SUCCESS_CREATE_MESSAGE = "Товар успешно добавлен в магазин";

    /**
     * Имя формы которое будет использоваться при редиректе с ошибками, чтобы спринг смог их подхватить
     */
    private static final String COMMODITY_FORM_ERRORS_NAME_FOR_REDIRECT = "org.springframework.validation.BindingResult.commodity";

    /**
     * Сервис для работы с товарами
     */
    private CommodityService commodityService;

    /**
     * Сервис для работы с категориями
     */
    private final CategoriesService categoriesService;

    /**
     * Конструктор для внедрения зависимостей
     *
     * @param commodityService  Сервис для работы с товарами
     * @param categoriesService Сервис для работы с категориями
     */
    @Autowired
    public CommodityController(final CommodityService commodityService,
                               final CategoriesService categoriesService) {
        this.commodityService = commodityService;
        this.categoriesService = categoriesService;
    }

    /**
     * Страница со списком товаров.
     *
     * @param model Свойства которые будут инжектиться в отображение
     * @return Имя вьюхи которую надо отрендерить
     */
    @GetMapping("/commodity")
    public String Commodity(Model model) {
        model.addAttribute("commodities", commodityService.findAll());

        return "commodity";
    }

    /**
     * На этой странице можно заполнить форму для создания товара и
     * отправить ее на обработку
     *
     * @param model Модель для заполнения страницы данными
     * @return Имя шаблона который надо отрисовать
     */
    @GetMapping(COMMODITY_CREATE_ENDPOINT)
    public String createNewCommodity(final Model model) {
        if (!model.containsAttribute(COMMODITY_MODEL_ATTRIBUTE)) {
            model.addAttribute(COMMODITY_MODEL_ATTRIBUTE, new CommodityForm());
        }
        model.addAttribute("categories", categoriesService.findAll());

        return CREATE_COMMODITY_VIEW_NAME;
    }

    /**
     * Создает новый товар в системе перед этим его валидирует
     *
     * @param commodity          Товар который мы создаем
     * @param bindingResult      Результат валидации формы товара
     * @param redirectAttributes Класс для хранения аттрибутов которые потом можно достать после
     *                           редиректа
     * @return Редирект на страницу со списком товаров или страница создания товара
     * с ошибками валидации
     */
    @PostMapping(COMMODITY_CREATE_ENDPOINT)
    public String processNewCommodity(@ModelAttribute(COMMODITY_MODEL_ATTRIBUTE) @Valid final CommodityForm commodity,
                                      final BindingResult bindingResult,
                                      final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(COMMODITY_FORM_ERRORS_NAME_FOR_REDIRECT, bindingResult);
            redirectAttributes.addFlashAttribute(COMMODITY_MODEL_ATTRIBUTE, commodity);

            return String.format("redirect:%s", COMMODITY_CREATE_ENDPOINT);
        }

        redirectAttributes.addFlashAttribute(COMMODITY_SUCCESS_CREATE_PRODUCT_KEY, COMMODITY_SUCCESS_CREATE_MESSAGE);
        commodityService.save(commodity);

        return "redirect:/commodity";
    }

    /**
     * Удаляет товар из базы данных
     *
     * @param id ID товара который будем удалять
     * @return Редирект на страницу со списком товаров
     */
    @GetMapping("/deleteCommodity/{id}")
    public String delete(@PathVariable long id) {
        commodityService.delete(id);
        return "redirect:/commodity";
    }

    @GetMapping("/updateCommodity/{id}")
    public String update(@ModelAttribute Commodity commodity) {
        commodityService.update(commodity);
        return "redirect:/commodity";
    }
}