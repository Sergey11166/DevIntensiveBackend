package hello.domain;

import java.util.Random;

import static hello.Constants.TOKEN;
import static hello.Constants.USER_ID;

@SuppressWarnings("unused")
public class AuthData {

    private User user;

    private String token;

    public AuthData() {
    }

    public AuthData(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public static AuthData createData(String userPhoto, String avatar, Random random) {
        AuthData authData = new AuthData();
        authData.setUser(User.createUser(USER_ID, userPhoto, avatar, random));
        authData.setToken(TOKEN);
        return authData;
    }
}