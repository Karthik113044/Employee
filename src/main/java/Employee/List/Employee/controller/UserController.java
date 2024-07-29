package Employee.List.Employee.controller;


import Employee.List.Employee.entity.PropertyUser;
import Employee.List.Employee.payload.JWTResponse;
import Employee.List.Employee.payload.LoginDto;
import Employee.List.Employee.payload.PropertyUserDto;
import Employee.List.Employee.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/api/v1/users/addUser
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody PropertyUserDto dto) {

        PropertyUser user = userService.addUser(dto);
        if (user == null) {
            return new ResponseEntity<>("Signup Failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Signup Successfully", HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/users/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        String jwtToken = userService.verifyLogin(loginDto);

        if (jwtToken!=null){
            JWTResponse jwtResponse = new JWTResponse();
            jwtResponse.setToken(jwtToken);

            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>("User Signed In Failed", HttpStatus.UNAUTHORIZED);
    }

}