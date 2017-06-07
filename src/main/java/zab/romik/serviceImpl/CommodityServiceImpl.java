package zab.romik.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zab.romik.dao.CategoriesDao;
import zab.romik.dao.CommodityDao;
import zab.romik.dao.CountryDao;
import zab.romik.entity.Categories;
import zab.romik.entity.Commodity;
import zab.romik.entity.Country;
import zab.romik.forms.CommodityForm;
import zab.romik.service.CommodityService;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class CommodityServiceImpl implements CommodityService {

    /** DAO для работы с товарами */
    private final CommodityDao commodityDao;
    private CategoriesDao categoriesDao;
    private CountryDao countryDao;

    @Autowired
    public CommodityServiceImpl(final CommodityDao commodityDao, final CategoriesDao categoriesDao, final CountryDao countryDao) {
        this.commodityDao = commodityDao;
        this.categoriesDao = Objects.requireNonNull(categoriesDao);
        this.countryDao = Objects.requireNonNull(countryDao);
    }

    /**
     * Создает товар исходя из формы которую отсылает пользователь.
     *
     * @param form Форма с данными товара который нужно создать
     */
    @Override
    public void save(final CommodityForm form) {
        final Categories category = categoriesDao.findOne(form.getCategoryId());
        final Country country = countryDao.findOne(form.getCountry());
        Objects.requireNonNull(category, "Category with id = " + form.getCategoryId() + " not found!");
        Objects.requireNonNull(country);
        commodityDao.save(Commodity.valueOf(form, category, country));
    }

    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    public Commodity findOne(long id) {
        return commodityDao.findOne(id);
    }

    public void delete(long id) {
        commodityDao.delete(id);
    }

    public void update(Commodity commodity) {
        commodityDao.save(commodity);
    }
}
