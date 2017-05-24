package zab.romik.service;

import zab.romik.entity.Counrty;

import java.util.List;

public interface CountryService {

    void save(Counrty country);

    List<Counrty> findAll();

    Counrty findOne(int id);

    void delete(int id);

    void update(Counrty country);
}
