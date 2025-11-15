package com.org.userproject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String username) {
        UserDTO userdto = userService.getUserByUsername(username);
        return ResponseEntity.ok(userdto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
        if (userService.getUserByUsername(userDTO.getUsername()) != null) {
            return ResponseEntity.badRequest().body("이미 존재하는 사용자입니다.");
        }

        userService.registerUser(userDTO);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }
}
