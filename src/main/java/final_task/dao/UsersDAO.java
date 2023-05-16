package final_task.dao;

import final_task.application.Roles;
import final_task.application.Users;

import java.util.List;

public interface UsersDAO {
    //create
    Users add (Users users);

    //read
    List<Users> getAll();
    Users getById(int id);

    List<Users> getUsersOfRole(Roles roles);
    //update
    void update (Users users);
    //delete
    void remove (Users users);
}
