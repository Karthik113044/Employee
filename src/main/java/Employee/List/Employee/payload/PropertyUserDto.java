package Employee.List.Employee.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropertyUserDto {

    private Long id;
    private String username;
    private String role;
    private String password;
}
