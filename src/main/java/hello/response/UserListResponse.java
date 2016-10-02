package hello.response;

import java.util.Random;

import hello.domain.UserListData;

import static hello.domain.UserListData.createUserListData;

/**
 * @author Sergey Vorobyev
 */

@SuppressWarnings("unused")
public class UserListResponse extends AbsResponse {

    private UserListData data;

    public UserListResponse() {
        super(true);
    }

    public UserListResponse(UserListData data) {
        this();
        this.data = data;
    }

    public UserListData getData() {
        return data;
    }
    public void setData(UserListData data) {
        this.data = data;
    }

    public static UserListResponse createUserListResponse(String userPhoto, String avatar, Random random) {
        UserListResponse response = new UserListResponse();
        response.setData(createUserListData(userPhoto, avatar, random));
        return response;
    }
}
