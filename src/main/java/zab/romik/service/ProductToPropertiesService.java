package zab.romik.service;

import zab.romik.entity.Categories;

import java.util.List;

public interface ProductToPropertiesService {

    void save(ProductToPropertiesService productToPropertiesService);

    List<Categories> findAll();

    Categories findOne(int id);

    void delete(int id);

    void update(ProductToPropertiesService productToPropertiesService);
}
