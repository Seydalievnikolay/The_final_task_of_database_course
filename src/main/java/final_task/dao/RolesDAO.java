package final_task.dao;

import final_task.application.Roles;

import java.util.List;

public interface RolesDAO {
    //create
    Roles add (Roles roles);

    //read
    List<Roles> getAll();
    Roles getById(int id);
    //update
    Roles update (Roles roles, int id);
    //delete
    void remove (Roles roles);
}