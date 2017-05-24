package zab.romik.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zab.romik.dao.OrdersDao;
import zab.romik.dao.UserDao;
import zab.romik.entity.Orders;
import zab.romik.entity.User;
import zab.romik.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrdersDao ordersDao;

    public void save(User user) {
        if (user.getEmail().contains("@")) {
            userDao.save(user);
        } else {
            System.out.println("wrong email");
        }
    }


    public List<User> findAll() {
        return userDao.findAll();
    }


    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public void delete(int id) {
        User user = userDao.findOne(id);
        List<Orders> orders = user.getOrders();
        for (Orders ord : orders) {
            ord.setUser(null);
            ordersDao.save(ord);
        }
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.save(user);
    }
}
