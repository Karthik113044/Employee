package Employee.List.Employee.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTResponse {

    private String tokenType="bearer";

    private String token;

}
