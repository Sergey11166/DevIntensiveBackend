package hello.response;

import hello.domain.UserListData;

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

    public static UserListResponse createUserListResponse(String userPhoto, String avatar) {
        UserListResponse response = new UserListResponse();
        response.setData(UserListData.createUserListData(userPhoto, avatar));
        return response;
    }
}
