package kata.anthony.app.service;

import kata.anthony.app.dao.UserDao;
import kata.anthony.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        userDao.add(new User("name", "surname", 20));
        userDao.add(new User("name2", "surname2", 30));
        userDao.add(new User("name3", "surname3", 40));
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
