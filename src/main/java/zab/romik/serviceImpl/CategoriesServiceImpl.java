package zab.romik.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zab.romik.dao.CategoriesDao;
import zab.romik.entity.Categories;
import zab.romik.service.CategoriesService;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesDao categoriesDao;

    public void save(Categories categiries) {
        categoriesDao.save(categiries);
    }

    public List<Categories> findAll() {
        return categoriesDao.findAll();
    }

    public Categories findOne(int id) {
        return categoriesDao.findOne(id);
    }

    public void delete(int id) {
        categoriesDao.delete(id);
    }

    public void update(Categories categiries) {
        categoriesDao.save(categiries);
    }

}
