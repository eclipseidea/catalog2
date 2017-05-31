package zab.romik.service;

import zab.romik.entity.Commodity;

import java.util.List;

public interface CommodityService {

    void save(Commodity commodity);

    List<Commodity> findAll();

    Commodity findOne(long id);

    void delete(long id);

    void update(Commodity commodity);
}
