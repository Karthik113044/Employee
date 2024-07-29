package Employee.List.Employee.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "t_Employee")
@Entity
public class Employees {

    @Column(name = "f_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_Name")
    private String name;

    @Column(name = "f_Email", unique = true)
    private String email;

    @Column(name = "f_Mobile", unique = true)
    private String mobile;

    @Column(name = "f_Designation")
    private String designation;

    @Column(name = "f_Gender")
    private String gender;

    @Column(name = "f_Course")
    private String course;

    @Column(name = "f_Createdate")
    @CreationTimestamp
    private Date createDate;

    @Lob
    @Column(name = "imagedata", length = 10000)
    private byte[] profilePicture;
}
