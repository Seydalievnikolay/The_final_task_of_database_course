package final_task.domain;

import final_task.application.Roles;
import final_task.application.Users;
import final_task.dao.RoleType;
import final_task.dao.RolesDAO;
import final_task.dao.UsersDAO;
import final_task.dao_impl.RolesDAOImpl;
import final_task.dao_impl.UsersDAOImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static  UsersDAO usersDAO = new UsersDAOImpl();
    static RolesDAO rolesDAO = new RolesDAOImpl();
    public static void main(String[] args) {
        //Создание ролей
        Roles developer = Roles.builder().type(RoleType.DEVELOPER).build();
        Roles manager = Roles.builder().type(RoleType.MANAGER).build();
        rolesDAO.add(developer);
        rolesDAO.add(manager);
        List<Roles> roles = new ArrayList<>();
        roles.add(rolesDAO.getById(2));

        //Создание пользователей
        Users firstUser = Users.builder()
                .userName("Harry")
                .login("harry@rambler.com")
                .pass("qwerty345")
                .dateAndTimeOfProfileCreation(LocalDateTime.now())
                .dateAndTimeOfProfileModification(LocalDateTime.now())
                .roles(roles)
                .build();
        Users added = usersDAO.add(firstUser);
        roles.add(rolesDAO.getById(1));
        added.setRoles(roles);
        usersDAO.update(added);







    }
}
