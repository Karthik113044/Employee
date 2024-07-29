package Employee.List.Employee.payload;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDto {

    private String username;
    private String password;
}
