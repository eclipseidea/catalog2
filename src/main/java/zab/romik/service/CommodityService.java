package zab.romik.service;

import zab.romik.entity.Commodity;
import zab.romik.forms.CommodityForm;

import java.util.List;

public interface CommodityService {

    void save(final CommodityForm commodity);

    List<Commodity> findAll();

    Commodity findOne(long id);

    void delete(long id);

    void update(Commodity commodity);
}
