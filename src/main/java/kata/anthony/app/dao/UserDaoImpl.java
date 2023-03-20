package kata.anthony.app.dao;

import kata.anthony.app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        entityManager.remove(get(id));
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }
}
