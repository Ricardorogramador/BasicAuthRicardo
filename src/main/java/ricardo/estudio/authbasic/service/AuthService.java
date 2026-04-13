package ricardo.estudio.authbasic.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ricardo.estudio.authbasic.dto.AuthResponse;
import ricardo.estudio.authbasic.dto.LoginRequest;
import ricardo.estudio.authbasic.dto.RegisterRequest;
import ricardo.estudio.authbasic.model.Role;
import ricardo.estudio.authbasic.model.User;
import ricardo.estudio.authbasic.repository.UserRepository;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final  JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public ResponseEntity<AuthResponse> register(RegisterRequest request){
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        User newUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encodedPassword)
                .role(Role.USER)
                .build();
            userRepository.save(newUser);
            String token = jwtService.generateToken(newUser);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new AuthResponse(token, newUser.getEmail(), newUser.getName()));
    }

    public ResponseEntity<AuthResponse> login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
     User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(()-> new RuntimeException("User not found"));
     String token = jwtService.generateToken(user);
     return ResponseEntity.ok(new AuthResponse(
             token,
             user.getEmail(),
             user.getName()
     ));
    }
}
