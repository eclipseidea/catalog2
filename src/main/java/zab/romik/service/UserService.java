package zab.romik.service;

import zab.romik.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void update(User user);

}
