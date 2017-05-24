package zab.romik.service;

import zab.romik.entity.Commodity;

import java.util.List;

public interface CommodityService {

    void save(Commodity commodity);

    List<Commodity> findAll();

    Commodity findOne(int id);

    void delete(int id);

    void update(Commodity commodity);
}
