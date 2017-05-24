package zab.romik.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zab.romik.dao.CountryDao;
import zab.romik.entity.Counrty;
import zab.romik.service.CountryService;

import java.util.List;


@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;


    public void save(Counrty country) {
        countryDao.save(country);

    }


    public List<Counrty> findAll() {
        return countryDao.findAll();
    }


    public Counrty findOne(int id) {
        return countryDao.findOne(id);
    }


    public void delete(int id) {
        countryDao.delete(id);
    }


    public void update(Counrty country) {
        countryDao.save(country);

    }
}
