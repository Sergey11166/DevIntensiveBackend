package hello.domain;

@SuppressWarnings("unused")
public class Data {

    private User user;

    private String token;

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

    public static Data createData() {
        Data data = new Data();
        data.setUser(User.createUser());
        data.setToken("gigipghwerfipug3hre3fgg");
        return data;
    }
}