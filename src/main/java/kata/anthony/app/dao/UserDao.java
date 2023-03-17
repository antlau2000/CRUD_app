package kata.anthony.app.dao;

import kata.anthony.app.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update(User user);

    User get(long id);

    void delete(long id);

    List<User> getAll();
}
