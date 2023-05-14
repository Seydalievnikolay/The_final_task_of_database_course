package final_task.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime dateAndTimeOfProfileCreation = LocalDateTime.now();
    @Column(name = "date_and_time_of_profile_modification")
    private LocalDateTime dateAndTimeOfProfileModification = LocalDateTime.now();
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_role",
    joinColumns = {@JoinColumn (name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Roles> roles;
}
