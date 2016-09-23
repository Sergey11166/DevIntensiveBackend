package hello.controller;

import org.springframework.http.HttpStatus;
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
            return new ResponseEntity<>(
                    new LikeResponse(createLikeData()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Bad token"), HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/user/" + USED_ID + "/unlike")
    public ResponseEntity<AbsResponse> unlike(@RequestHeader(value="X-Access-Token") String token,
                                            @RequestHeader(value = "Request-User-Id") String userId) {

        if (token.equals(TOKEN)) {
            return new ResponseEntity<>(
                    new LikeResponse(createUnlikeData()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Bad token"), HttpStatus.FORBIDDEN);
        }
    }
}
