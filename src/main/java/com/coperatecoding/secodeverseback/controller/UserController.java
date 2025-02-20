package com.coperatecoding.secodeverseback.controller;

import com.coperatecoding.secodeverseback.domain.User;
import com.coperatecoding.secodeverseback.dto.UserDTO;
//import com.coperatecoding.secodeverseback.service.JwtService;
import com.coperatecoding.secodeverseback.exception.UserInfoDuplicatedException;
import com.coperatecoding.secodeverseback.service.JwtService;
import com.coperatecoding.secodeverseback.service.UserService;
import com.nimbusds.openid.connect.sdk.UserInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "UserController", description = "User 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;
//    private final JwtService jwtService;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "회원가입", description = """
    [모두 접근가능] 회원가입을 할 수 있습니다.<br>
    201: 성공<br>
    409: 같은 아이디or닉네임이 이미 존재함
    """)
    @PostMapping("/signup")
    public ResponseEntity signUp (@RequestBody UserDTO.RegisterRequest registerRequest) throws UserInfoDuplicatedException {
        userService.signUp(registerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public ResponseEntity<UserDTO.LoginResponse> login(@RequestBody UserDTO.LoginRequest loginRequest, HttpServletRequest request) {
        UserDTO.LoginResponse loginResponse = userService.login(loginRequest, request);

        return ResponseEntity.ok(loginResponse);
    }

    @Operation(summary = "로그아웃", description = """
    [로그인 필요] 로그아웃을 합니다.<br>
    jwt토큰이 만료됩니다<br>
    로그아웃 리다이랙트 url 꼭 넣기. &logout_redirect_uri={url} <br>
    200: 성공<br>
    """)
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@AuthenticationPrincipal User user) {
        userService.logout(user.getId());

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "중복 아이디 확인")
    @GetMapping("/id/{id}/exists")
    public ResponseEntity<Map> isExistsId(@PathVariable("id") String id) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("exists", userService.isExistId(id));

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @Operation(summary = "중복 닉네임 확인")
    @GetMapping("/nickname/{nickname}/exists")
    public ResponseEntity<Map> isExistsNickname(@PathVariable("nickname") String nickName) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("exists", userService.isExistNickname(nickName));

        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @Operation(summary = "내 정보 조회", description = """
    [로그인 필요]<br>
    200: 성공<br>
    403: 로그인 필요
    """)
    @GetMapping("/info/my")
    public ResponseEntity<UserDTO.UserInfoResponse> getUserInfo(@AuthenticationPrincipal User user) {
        UserDTO.UserInfoResponse userInfo = userService.getUserInfo(user);

        return ResponseEntity.ok(userInfo);
    }



}
