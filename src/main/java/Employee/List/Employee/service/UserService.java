package Employee.List.Employee.service;


import Employee.List.Employee.entity.PropertyUser;
import Employee.List.Employee.payload.LoginDto;
import Employee.List.Employee.payload.PropertyUserDto;
import Employee.List.Employee.repository.PropertyUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private JWTService jwtService;

    private PropertyUserRepository userRepository;

    public UserService(JWTService jwtService, PropertyUserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public PropertyUser addUser(PropertyUserDto dto) {
        PropertyUser user = new PropertyUser();

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setRole(dto.getRole());
        user.setPassword(BCrypt.hashpw(dto.getPassword(),BCrypt.gensalt(10)));

        return userRepository.save(user);
    }

    public String verifyLogin(LoginDto loginDto) {
        Optional<PropertyUser> opUser = userRepository.findByUsername(loginDto.getUsername());
        if (opUser.isPresent()) {
            PropertyUser user = opUser.get();
            if(BCrypt.checkpw(loginDto.getPassword(), user.getPassword())) {
                return jwtService.generateToken(user);
            }
        }
        return null;
    }
}

