package zab.romik.service;

import zab.romik.entity.Categories;

import java.util.List;
import java.util.Properties;

public interface PropertiesService {

    void save(Properties properties);

    List<Categories> findAll();

    Categories findOne(long id);

    void delete(long id);

    void update(Properties properties);
}
