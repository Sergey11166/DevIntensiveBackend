package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.response.ErrorResponse;
import hello.request.UserLoginRequest;
import hello.response.AbsResponse;

import static hello.response.UserModelResponse.createUserModelResponse;

@Controller
@SuppressWarnings("unused")
public class AuthController {

    @RequestMapping("/login")
    public ResponseEntity<AbsResponse> user(@RequestBody UserLoginRequest request) {
        if (request.getEmail().equals("sevoro.sv@gmail.com") && request.getPassword().equals("12345")) {
            return new ResponseEntity<>(createUserModelResponse(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("wrong username or password"), HttpStatus.FORBIDDEN);
        }
    }
}
