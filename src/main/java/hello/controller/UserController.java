package hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import hello.Constants;
import hello.request.UpdateContactsRequest;
import hello.request.UserLoginRequest;
import hello.response.AbsResponse;
import hello.response.ErrorResponse;

import static hello.Constants.USED_ID;
import static hello.response.UpdateContactsResponse.createUpdateContactsResponse;
import static hello.response.UserModelResponse.createUserModelResponse;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;

@Controller
@SuppressWarnings("unused")
public class UserController {

    @PostMapping("/login")
    public ResponseEntity<AbsResponse> login(@RequestBody UserLoginRequest request) {
        if (request.getEmail().equals("sevoro.sv@gmail.com") && request.getPassword().equals("12345")) {
            return new ResponseEntity<>(createUserModelResponse(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("wrong username or password"), FORBIDDEN);
        }
    }

    @PutMapping("user/" + USED_ID + "/contacts")
    public ResponseEntity<AbsResponse> updateContacts(@RequestBody UpdateContactsRequest request,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token.equals(Constants.TOKEN)) {
            return new ResponseEntity<>(createUpdateContactsResponse(), OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Bad token"), FORBIDDEN);
        }
    }
}
