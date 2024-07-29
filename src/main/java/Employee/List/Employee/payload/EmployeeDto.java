package Employee.List.Employee.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {

    private String name;
    private String email;
    private String mobile;
    private String designation;
    private String gender;
    private String course;
    private byte[] profilePicture;
}
