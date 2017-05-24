package zab.romik.service;

import zab.romik.entity.Categories;

import java.util.List;

public interface CategoriesService {
    void save(Categories categiries);

    List<Categories> findAll();

    Categories findOne(int id);

    void delete(int id);

    void update(Categories categiries);
}
