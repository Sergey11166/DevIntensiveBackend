package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.nio.file.Path;
import java.util.Optional;

import hello.Constants;
import hello.request.UpdateContactsRequest;
import hello.request.UserLoginRequest;
import hello.response.AbsResponse;
import hello.response.ErrorResponse;
import hello.storage.StorageService;

import static hello.Constants.USED_ID;
import static hello.response.UpdateContactsResponse.createUpdateContactsResponse;
import static hello.response.UserModelResponse.createUserModelResponse;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Controller
@SuppressWarnings("unused")
public class UserController {

    @Autowired private StorageService storage;

    @PostMapping("/login")
    public ResponseEntity<AbsResponse> login(@RequestBody UserLoginRequest request) {
        if (request.getEmail().equals("sevoro.sv@gmail.com") && request.getPassword().equals("12345")) {

            Optional<Path> userPhoto = storage.loadAll()
                    .filter(path -> path.getFileName().toString().contains("user_photo"))
                    .findFirst();

            Optional<Path> avatar = storage.loadAll()
                    .filter(path -> path.getFileName().toString().contains("avatar"))
                    .findFirst();

            String userPhotoString = userPhoto.isPresent() ? userPhoto.get().getFileName().toString() : "0";
            String avatarString = avatar.isPresent() ? avatar.get().getFileName().toString() : "0";

            return ResponseEntity
                    .ok()
                    .body(createUserModelResponse(userPhotoString, avatarString));

        } else {
            return ResponseEntity
                    .status(FORBIDDEN)
                    .body(new ErrorResponse("wrong username or password"));
        }
    }

    @PutMapping("user/" + USED_ID + "/contacts")
    public ResponseEntity<AbsResponse> updateContacts(@RequestBody UpdateContactsRequest request,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token.equals(Constants.TOKEN)) {
            return ResponseEntity
                    .ok()
                    .body(createUpdateContactsResponse());
        } else {
            return ResponseEntity.status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }
}
