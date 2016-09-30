package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.nio.file.Path;
import java.util.Optional;
import java.util.Random;

import hello.request.UpdateContactsRequest;
import hello.request.LoginRequest;
import hello.response.AbsResponse;
import hello.response.ErrorResponse;
import hello.response.UserListResponse;
import hello.storage.StorageService;

import static hello.Constants.TOKEN;
import static hello.Constants.USED_ID;
import static hello.response.AuthResponse.createUserModelResponse;
import static hello.response.UpdateContactsResponse.createUpdateContactsResponse;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Controller
@SuppressWarnings("unused")
public class UserController {

    @Autowired private StorageService storage;
    private final Random random = new Random();

    @PostMapping("/login")
    public ResponseEntity<AbsResponse> login(@RequestBody LoginRequest request) {
        if (request.getEmail().equals("") && request.getPassword().equals("")) {
            return ResponseEntity
                    .ok()
                    .body(createUserModelResponse(getUserPhoto(), getAvatar(), random));
        } else {
            return ResponseEntity
                    .status(FORBIDDEN)
                    .body(new ErrorResponse("wrong username or password"));
        }
    }

    @GetMapping("/user/list")
    public ResponseEntity<AbsResponse> getUsers(@RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {
        if (token.equals(TOKEN)) {
            return ResponseEntity.
                    ok()
                    .body(UserListResponse.createUserListResponse(getUserPhoto(), getAvatar(), random));
        } else {
            return ResponseEntity.status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }

    @PutMapping("user/" + USED_ID + "/contacts")
    public ResponseEntity<AbsResponse> updateContacts(@RequestBody UpdateContactsRequest request,
            @RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token.equals(TOKEN)) {
            return ResponseEntity
                    .ok()
                    .body(createUpdateContactsResponse());
        } else {
            return ResponseEntity.status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }

    private String getUserPhoto() {
        Optional<Path> userPhoto = storage.loadAll()
                .filter(path -> path.getFileName().toString().contains("user_photo"))
                .findFirst();
        return userPhoto.isPresent() ? userPhoto.get().getFileName().toString() : "0";
    }

    private String getAvatar() {
        Optional<Path> avatar = storage.loadAll()
                .filter(path -> path.getFileName().toString().contains("avatar"))
                .findFirst();
        return avatar.isPresent() ? avatar.get().getFileName().toString() : "0";
    }
}
