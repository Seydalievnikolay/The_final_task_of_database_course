package final_task.domain;

import final_task.application.Roles;
import final_task.application.Users;
import final_task.dao.RolesDAO;
import final_task.dao.UsersDAO;
import final_task.dao_impl.RolesDAOImpl;
import final_task.dao_impl.UsersDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAOImpl();
        RolesDAO rolesDAO = new RolesDAOImpl();
        //Создание пользователей
        Users users = new Users();
        users.setId(1);
        users.setUserName("Alex");
        users.setLogin("alex@mail.ru");
        users.setPass("54Dl1");
        usersDAO.add(users);

        Users users2 = new Users();
        users2.setId(2);
        users2.setUserName("Tom");
        users2.setLogin("tom2@mail.com");
        users2.setPass("qwerty123");
        usersDAO.add(users2);

        List<Users> usersList = usersDAO.getAll();
        for (Users e: usersList) {
            System.out.println(e);
        }
        usersDAO.getById(2).getRoles();





    }
}
