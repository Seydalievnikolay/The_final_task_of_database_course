package final_task.application;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
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
    private LocalDateTime dateAndTimeOfProfileCreation;
    @Column(name = "date_and_time_of_profile_modification")
    private LocalDateTime dateAndTimeOfProfileModification;
    @ManyToMany(fetch = FetchType.EAGER)
    /*@JoinTable(
            name = "users_role",
    joinColumns = {@JoinColumn (name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})*/
    private List<Roles> roles = new ArrayList<>();
}
