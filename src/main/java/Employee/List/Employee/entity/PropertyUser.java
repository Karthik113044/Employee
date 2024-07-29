package Employee.List.Employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "property_user")
public class PropertyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 150, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "role", nullable = false, length = 40)
    private String role;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 255)
    private String password;


}
