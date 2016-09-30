package hello.response;

import java.util.Random;

import hello.domain.AuthData;

/**
 * @author Sergey Vorobyev.
 */

@SuppressWarnings("unused")
public class AuthResponse extends AbsResponse {

    private AuthData data;

    public AuthResponse() {
        super(true);
    }

    public AuthResponse(AuthData data) {
        this();
        this.data = data;
    }

    public AuthData getData() {
        return data;
    }
    public void setData(AuthData data) {
        this.data = data;
    }

    public static AuthResponse createUserModelResponse(String userPhoto, String avatar, Random random) {
        return new AuthResponse(AuthData.createData(userPhoto, avatar, random));
    }
}
