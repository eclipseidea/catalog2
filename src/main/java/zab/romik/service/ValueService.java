package zab.romik.service;

import zab.romik.entity.Categories;
import zab.romik.entity.Valuess;

import java.util.List;

public interface ValueService {

    void save(Valuess value);

    List<Categories> findAll();

    Categories findOne(int id);

    void delete(int id);

    void update(Valuess value);
}
