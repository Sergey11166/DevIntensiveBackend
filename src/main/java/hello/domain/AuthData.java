package hello.domain;

import static hello.Constants.TOKEN;

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

    public static AuthData createData(String userPhoto, String avatar) {
        AuthData authData = new AuthData();
        authData.setUser(User.createUser(userPhoto, avatar));
        authData.setToken(TOKEN);
        return authData;
    }
}