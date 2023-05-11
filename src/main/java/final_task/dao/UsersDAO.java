package final_task.dao;

import final_task.application.Users;

import java.util.List;

public interface UsersDAO {
    //create
    Users add (Users users);

    //read
    List<Users> getAll();
    Users getById(int id);
    //update
    Users update (Users users, int id);
    //delete
    void remove (Users users);
}
