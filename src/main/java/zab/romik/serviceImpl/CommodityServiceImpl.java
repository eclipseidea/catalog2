package zab.romik.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zab.romik.dao.CommodityDao;
import zab.romik.entity.Commodity;
import zab.romik.service.CommodityService;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;


    public void save(Commodity commodity) {

        commodityDao.save(commodity);
    }

    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    public Commodity findOne(long id) {
        return commodityDao.findOne(id);
    }

    public void delete(long id) {
        commodityDao.delete(id);
    }

    public void update(Commodity commodity) {
        commodityDao.save(commodity);
    }
}
