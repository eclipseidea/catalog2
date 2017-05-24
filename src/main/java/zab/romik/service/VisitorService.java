package zab.romik.service;

import zab.romik.entity.Visitor;

import java.util.List;

/**
 * Created by user on 05/24/2017.
 */
public interface VisitorService {

    void save(Visitor visitor);

    List<Visitor> findAll();

    Visitor findOne(int id);

    void delete(int id);

    void update(Visitor visitor);

}
