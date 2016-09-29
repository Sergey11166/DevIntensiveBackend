package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import hello.response.AbsResponse;
import hello.response.ErrorResponse;
import hello.response.LikeResponse;

import static hello.Constants.TOKEN;
import static hello.Constants.USED_ID;
import static hello.domain.LikesData.createLikeData;
import static hello.domain.LikesData.createUnlikeData;
import static org.springframework.http.HttpStatus.FORBIDDEN;

/**
 * @author Sergey Vorobyev
 */

@Controller
@SuppressWarnings("unused")
class LikesController {

    @PostMapping("/user/" + USED_ID + "/like")
    public ResponseEntity<AbsResponse> like(@RequestHeader(value="X-Access-Token") String token,
            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token.equals(TOKEN)) {
            return ResponseEntity.ok()
                    .body(new LikeResponse(createLikeData()));
        } else {
            return ResponseEntity
                    .status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }

    @PostMapping("/user/" + USED_ID + "/unlike")
    public ResponseEntity<AbsResponse> unlike(@RequestHeader(value="X-Access-Token") String token,
                                            @RequestHeader(value = "Request-User-Id") String userId) {
        if (token.equals(TOKEN)) {
            return ResponseEntity
                    .ok()
                    .body(new LikeResponse(createUnlikeData()));
        } else {
            return ResponseEntity
                    .status(FORBIDDEN)
                    .body(new ErrorResponse("Bad token"));
        }
    }
}
