package final_task.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String userName;
    private String login;
    private String pass;
    @Column(name = "date_and_time_of_profile_creation")
    private int dateAndTimeOfProfileCreation;
    @Column(name = "date_and_time_of_profile_modification")
    private int dateAndTimeOfProfileModification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_roles_id")
    private Roles roles;
}
