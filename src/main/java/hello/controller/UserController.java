package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.domain.AbsEntity;
import hello.domain.Error;
import hello.request.UserLoginRequest;

import static hello.response.UserModelResponse.createUserModelResponse;

@Controller
@SuppressWarnings("unused")
public class UserController {

    @RequestMapping("/login")
    public ResponseEntity<AbsEntity> user(@RequestBody UserLoginRequest request) {
        if (request.getEmail().equals("sevoro.sv@gmail.com") && request.getPassword().equals("12345")) {
            return new ResponseEntity<>(createUserModelResponse(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Error("wrong username or password"), HttpStatus.FORBIDDEN);
        }
    }
}
