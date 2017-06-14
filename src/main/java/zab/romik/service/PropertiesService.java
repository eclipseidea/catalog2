package zab.romik.service;

import java.util.List;
import java.util.Properties;

public interface PropertiesService {

    void save(Properties properties);

    List<Properties> findAll();

    Properties findOne(long id);

    void delete(long id);

    void update(Properties properties);
}
