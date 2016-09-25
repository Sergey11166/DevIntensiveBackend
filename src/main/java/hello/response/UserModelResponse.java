package hello.response;

import hello.domain.AuthData;

/**
 * @author Sergey Vorobyev.
 */

@SuppressWarnings("unused")
public class UserModelResponse extends AbsResponse {

    private AuthData data;

    public UserModelResponse() {
        super(true);
    }

    public UserModelResponse(AuthData data) {
        this();
        this.data = data;
    }

    public AuthData getData() {
        return data;
    }
    public void setData(AuthData data) {
        this.data = data;
    }

    public static UserModelResponse createUserModelResponse(String userPhoto, String avatar) {
        return new UserModelResponse(AuthData.createData(userPhoto, avatar));
    }
}
