package final_task.dao_impl;

import final_task.application.Users;
import final_task.dao.UsersDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    private  final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    private  final SessionFactory sessionFactory = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    @Override
    public Users add(Users users) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return users;
    }

    @Override
    public List<Users> getAll(int id) {
        Session session = sessionFactory.openSession();
        List<Users> users = new ArrayList<>();
        try {
            session.beginTransaction();
            users = session.createQuery("FROM Users ", Users.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public Users getById(int id) {
        Session session = sessionFactory.openSession();
        Users users = null;
        try {
            session.beginTransaction();
            Query<Users> query = session.createQuery(
                            "FROM Users WHERE id = :fId", Users.class)
                    .setParameter("fId", id);
            session.getTransaction().commit();
            users = query.uniqueResult();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public Users update(Users users, int id) {
        Session session = sessionFactory.openSession();
        Users usersResult = null;
        try {
            session.beginTransaction();
            Users query = session.createQuery(
                            "UPDATE Users SET userName = :fUserName, login = :fLogin, pass = :fPass," +
                                    "dateAndTimeOfProfileCreation = :fDateAndTimeOfProfileCreation," +
                                    "dateAndTimeOfProfileModification = :fDateAndTimeOfProfileModification WHERE id = :fId", Users.class)
                    .setParameter("fUserName", users.getUserName())
                    .setParameter("fLogin", users.getLogin())
                    .setParameter("fPass", users.getPass())
                    .setParameter("fDateAndTimeOfProfileCreation", users.getDateAndTimeOfProfileCreation())
                    .setParameter("fDateAndTimeOfProfileModification", users.getDateAndTimeOfProfileModification())
                    .uniqueResult();
            session.getTransaction().commit();
            usersResult = query;
        } catch (Exception e) {
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return usersResult;
    }

    @Override
    public void remove(Users users) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int query = session.createQuery(
                            "DELETE Users WHERE id = :fId", Users.class)
                    .setParameter("fId", users.getId())
                    .executeUpdate();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
