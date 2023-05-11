package final_task.dao_impl;

import final_task.application.Roles;
import final_task.application.Users;
import final_task.dao.RolesDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RolesDAOImpl implements RolesDAO {
    private  final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml").build();
    private  final SessionFactory sessionFactory = new MetadataSources(registry)
            .addAnnotatedClass(Roles.class)
            .addAnnotatedClass(Users.class)
            .buildMetadata().buildSessionFactory();
    @Override
    public Roles add(Roles roles) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(roles);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return roles;
    }

    @Override
    public List<Roles> getAll() {
        Session session = sessionFactory.openSession();
        List<Roles> roles = new ArrayList<>();
        try {
            session.beginTransaction();
            roles = session.createQuery("FROM Roles ", Roles.class).list();
            session.getTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return roles;
    }

    @Override
    public Roles getById(int id) {
        Session session = sessionFactory.openSession();
        Roles roles = null;
        try {
            session.beginTransaction();
            Query<Roles> query = session.createQuery(
                            "FROM Roles WHERE id = :fId", Roles.class)
                    .setParameter("fId", id);
            session.getTransaction().commit();
            roles = query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return roles;
    }

    @Override
    public Roles update(Roles roles, int id) {
        Session session = sessionFactory.openSession();
        Roles rolesResult = null;
        try {
            session.beginTransaction();
            Roles query = session.createQuery(
                            "UPDATE Roles SET rolesName = :fRolesName WHERE id = :fId", Roles.class)
                    .setParameter("fRolesName", roles.getRolesName())
                    .uniqueResult();
            session.getTransaction().commit();
            rolesResult = query;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rolesResult;
    }

    @Override
    public void remove(Roles roles) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            int query = session.createQuery("DELETE Roles WHERE id = :fId", Roles.class)
                    .setParameter("fId", roles.getId())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
