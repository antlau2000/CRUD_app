package kata.anthony.app.dao;

import kata.anthony.app.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        User user = get(id);
        entityManager.remove(user);
    }

    @Override
    public List<User> getAll() {
        return  entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }
}