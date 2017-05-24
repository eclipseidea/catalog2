package zab.romik.service;

import zab.romik.entity.Categories;

import java.util.List;
import java.util.Properties;

public interface PropertiesService {

    void save(Properties properties);

    List<Categories> findAll();

    Categories findOne(int id);

    void delete(int id);

    void update(Properties properties);
}
