package hello.domain;

import static hello.Constants.TOKEN;

@SuppressWarnings("unused")
public class UserData {

    private User user;

    private String token;

    public UserData() {
    }

    public UserData(User user, String token) {
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

    public static UserData createData() {
        UserData data = new UserData();
        data.setUser(User.createUser());
        data.setToken(TOKEN);
        return data;
    }
}